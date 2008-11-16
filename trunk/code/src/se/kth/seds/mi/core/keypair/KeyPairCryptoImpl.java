package se.kth.seds.mi.core.keypair;

import org.apache.catalina.util.HexUtils;
import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Shanbo Li
 */
public class KeyPairCryptoImpl implements KeyPairCrypto {
    private String message;
    private HashAlgorithm hashAlgorithm;
    private static final HashAlgorithm DEFAULT_HASH_ALGORITHM = HashAlgorithm.SHA_1;

    public static final Logger logger = Logger.getLogger(KeyPairCryptoImpl.class.getName());

    public KeyPairCryptoImpl(String message) {
        this.message = message;
        this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
    }

    public KeyPairCryptoImpl(String message, HashAlgorithm hashAlgorithm) {
        this.message = message;
        this.hashAlgorithm = hashAlgorithm;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public String sign(PrivateKey priv) throws OperationFailedException {
        Signature dsa;
        try {
            dsa = Signature.getInstance(hashAlgorithm.getKeyPairAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Can not get the algrothm, check if your JRE installed correctly...", e);
            throw new OperationFailedException(e);
        }

        /* Initializing the object with a private key */
        try {
            dsa.initSign(priv);
        } catch (InvalidKeyException e) {
            logger.log(Level.SEVERE, "Invalid Key", e);
            throw new OperationFailedException(e);
        }

        /* Update and sign the data */
        try {
            dsa.update(HexUtils.convert(message));
        } catch (SignatureException e) {
            throw new OperationFailedException(e);
        }

        try {
            byte[] sig = dsa.sign();
            return HexUtils.convert(sig);
        } catch (SignatureException e) {
            logger.log(Level.SEVERE, "SignatureException, sign failed", e);
            throw new OperationFailedException(e);
        }
    }

    public boolean verify(PublicKey publicKey, String mac) throws OperationFailedException {
        /* Initializing the object with the public key */
        Signature dsa;
        try {
            dsa = Signature.getInstance(hashAlgorithm.getKeyPairAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Can not get the algrothm, check if your JRE installed correctly...", e);
            throw new OperationFailedException(e);
        }

        try {
            dsa.initVerify(publicKey);
        } catch (InvalidKeyException e) {
            logger.log(Level.SEVERE, "Invalid Key", e);
            throw new OperationFailedException(e);
        }

        /* Update and verify the data */
        try {
            dsa.update(HexUtils.convert(message));
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

