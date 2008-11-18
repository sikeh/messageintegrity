package se.kth.seds.mi.core.crypto.keypair;

import org.apache.catalina.util.HexUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

import java.security.*;

/**
 * @author Shanbo Li
 */
public class KeyPairCryptoImpl implements KeyPairCrypto {
    private String message;
    private HashAlgorithm hashAlgorithm;
    private static final HashAlgorithm DEFAULT_HASH_ALGORITHM = HashAlgorithm.SHA1;

    public final Log logger = LogFactory.getLog(getClass());

    public KeyPairCryptoImpl() {
    }

    public KeyPairCryptoImpl(String message) {
        this(message, DEFAULT_HASH_ALGORITHM);
    }

    public KeyPairCryptoImpl(String message, HashAlgorithm hashAlgorithm) {
        this.setMessage(message);
        this.setHashAlgorithm(hashAlgorithm);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message == null)
            throw new NullPointerException("message can not be null");

        this.message = message;
    }

    public HashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        if (hashAlgorithm == null)
            throw new NullPointerException("Hash Algorithm can not be null");

        this.hashAlgorithm = hashAlgorithm;
    }

    public String sign(PrivateKey privateKey) throws OperationFailedException {
        if (privateKey == null) throw new NullPointerException("Private key can not be null");
        Signature dsa;
        try {
            dsa = Signature.getInstance(hashAlgorithm.getKeyPairAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            logger.error("Can not get the algrothm, check if your JRE installed correctly...", e);
            throw new OperationFailedException(e);
        }

        /* Initializing the object with a private key */
        try {
            dsa.initSign(privateKey);
        } catch (InvalidKeyException e) {
            logger.error("Invalid Key", e);
            throw new OperationFailedException(e);
        }

        /* Update and sign the data */
        try {
            dsa.update(message.getBytes());
        } catch (SignatureException e) {
            throw new OperationFailedException(e);
        }

        try {
            byte[] sig = dsa.sign();
            return HexUtils.convert(sig);
        } catch (SignatureException e) {
            logger.error("SignatureException, sign failed", e);
            throw new OperationFailedException(e);
        }
    }

    public boolean verify(PublicKey publicKey, String mac) throws OperationFailedException {
        if (publicKey == null) throw new NullPointerException("public key can not be null");
        if (mac == null) throw new NullPointerException("MAC can not be null");

        /* Initializing the object with the public key */
        Signature dsa;
        try {
            dsa = Signature.getInstance(hashAlgorithm.getKeyPairAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            logger.error("Can not get the algrothm, check if your JRE installed correctly...", e);
            throw new OperationFailedException(e);
        }

        try {
            dsa.initVerify(publicKey);
        } catch (InvalidKeyException e) {
            logger.error("Invalid Key", e);
            throw new OperationFailedException(e);
        }

        /* Update and verify the data */
        try {
            dsa.update(message.getBytes());
        } catch (SignatureException e) {
            throw new OperationFailedException(e);
        }

        try {
            return dsa.verify(HexUtils.convert(mac));
        } catch (SignatureException e) {
            throw new OperationFailedException(e);
        }
    }
}

