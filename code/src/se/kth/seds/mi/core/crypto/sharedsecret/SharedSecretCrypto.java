package se.kth.seds.mi.core.crypto.sharedsecret;

import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

/**
 * @author Shanbo Li
 */
public interface SharedSecretCrypto {

    /**
     * Get the shared secret of this crypto.
     *
     * @return shared secret
     */
    public String getSharedSecret();

    /**
     * Set the shared secret of this crypto.
     *
     * @param sharedSecret the shared secret.
     */
    public void setSharedSecret(String sharedSecret);

    /**
     * Get the message of this crypto
     *
     * @return the message (main text)
     */
    public String getMessage();

    /**
     * Set the message of this crypto
     *
     * @param message the message.
     */
    public void setMessage(String message);

    /**
     * Set the algorithm of hash.
     *
     * @param hashAlgorithm the algorithm
     */
    public void setHashAlgorithm(HashAlgorithm hashAlgorithm);

    /**
     * Get the algorithm.
     *
     * @return algorithm
     */
    public HashAlgorithm getHashAlgorithm();

    /**
     * Create the message authencication code (MAC)
     *
     * @return MAC
     * @throws se.kth.seds.mi.core.exceptions.OperationFailedException if the required operation failed.
     */
    public String createMAC() throws OperationFailedException;
}
