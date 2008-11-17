package se.kth.seds.mi.core.crypto.sharedsecret;

import org.apache.catalina.util.HexUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Shanbo Li
 */
public class SharedSecretCryptoImpl implements SharedSecretCrypto {
    private String sharedSecret;
    private String message;
    private HashAlgorithm hashAlgorithm;
    public final Log logger = LogFactory.getLog(getClass());
    public static final HashAlgorithm DEFAULT_HASH_ALGORITHM = HashAlgorithm.SHA1;

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
        this.setSharedSecret(sharedSecret);
        this.setMessage(message);
        this.setHashAlgorithm(hashAlgorithm);
    }

    public SharedSecretCryptoImpl() {
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

    /**
     * {@inheritDoc}
     */
    public HashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * {@inheritDoc}
     */
    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        if (hashAlgorithm == null) throw new NullPointerException("Hash algorithm can not be null");
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
            logger.error("Can not get the algrothm, check if your JRE installed correctly...", e);
            throw new OperationFailedException(e);
        }
        byte[] plainText = sb.toString().getBytes();
        byte[] hashCode = sha.digest(plainText);
        return HexUtils.convert(hashCode);
    }
}
