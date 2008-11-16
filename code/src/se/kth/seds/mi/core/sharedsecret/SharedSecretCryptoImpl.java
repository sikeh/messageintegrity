package se.kth.seds.mi.core.sharedsecret;

import org.apache.catalina.util.HexUtils;
import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @author Shanbo Li
 */
public class SharedSecretCryptoImpl implements SharedSecretCrypto {
    private String sharedSecret;
    private String message;
    private HashAlgorithm hashAlgorithm;

    public static final HashAlgorithm DEFAULT_HASH_ALGORITHM = HashAlgorithm.SHA_1;

    /**
     * Create a crypto with a default hash algorithm by the given parameters<br/>
     * The default algorithm is "SHA".
     *
     * @param sharedSecret the shared secret
     * @param message      the message
     */
    public SharedSecretCryptoImpl(String sharedSecret, String message) {
        this(sharedSecret, message, DEFAULT_HASH_ALGORITHM);
    }

    /**
     * Create a crypto by the given parameters
     *
     * @param sharedSecret  the shared secret
     * @param message       message
     * @param hashAlgorithm the name of the algorithm requested.
     */
    public SharedSecretCryptoImpl(String sharedSecret, String message, HashAlgorithm hashAlgorithm) {
        if (sharedSecret == null) throw new NullPointerException("sharedSecret can NOT be null");
        if (message == null) throw new NullPointerException("message can NOT be null");
        if (hashAlgorithm == null) throw new NullPointerException("algorithm can NOT be null");
        this.sharedSecret = sharedSecret;
        this.message = message;
        this.hashAlgorithm = hashAlgorithm;
    }

    /**
     * {@inheritDoc}
     */
    public String getSharedSecret() {
        return sharedSecret;
    }

    /**
     * {@inheritDoc}
     */
    public void setSharedSecret(String sharedSecret) {
        if (sharedSecret == null) throw new NullPointerException("sharedSecret could not be null");
        this.sharedSecret = sharedSecret;
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    public void setMessage(String message) {
        if (message == null) throw new NullPointerException("message could not be null");
        this.message = message;
    }

    public HashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    /**
     * {@inheritDoc}
     */
    public String createMAC() throws OperationFailedException {
        StringBuilder sb = new StringBuilder().append(sharedSecret).append(message);
        MessageDigest sha;
        try {
            sha = MessageDigest.getInstance(hashAlgorithm.getSharedSecretAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(SharedSecretCryptoImpl.class.getName()).log(Level.SEVERE,"Can not get the algrothm, check if your JRE installed correctly...",e);
            throw new OperationFailedException(e);
        }
        byte[] plainText = HexUtils.convert(sb.toString());
        byte[] hashCode = sha.digest(plainText);
        return HexUtils.convert(hashCode);
    }
}
