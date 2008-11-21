package se.kth.seds.mi.core.crypto.keypair;

import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author Shanbo Li
 */
public interface KeyPairCrypto {
    /**
     * Get the message.
     *
     * @return the message.
     */
    public String getMessage();

    /**
     * Set the message
     *
     * @param message the given message.
     */
    public void setMessage(String message);

    /**
     * Get hash algorithm
     *
     * @return the algorithm
     */
    public HashAlgorithm getHashAlgorithm();

    /**
     * Set hash algorithm
     *
     * @param hashAlgorithm the given algorithm
     */
    public void setHashAlgorithm(HashAlgorithm hashAlgorithm);

    /**
     * Sign a message according the given private key.
     *
     * @param privateKey the private key
     * @return Message authentication code
     * @throws OperationFailedException something wrong when sign the message. For detail, see exception message.
     */
    public String hashAndSign(PrivateKey privateKey) throws OperationFailedException;

    /**
     * Verify a message according the public key and mac
     *
     * @param publicKey the given public key.
     * @param mac the message authentication code
     * @return {@code true} if authentication success, {@code false} otherwise
     * @throws OperationFailedException something wrong when verify the message. For detail, see exception message.
     */
    public boolean verify(PublicKey publicKey, String mac) throws OperationFailedException;
}
