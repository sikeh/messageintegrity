package se.kth.seds.mi.core.crypto.keypair;

import se.kth.seds.mi.core.exceptions.OperationFailedException;

/**
 * @author Shanbo Li
 */
public interface KeyPairGeneratorIF {
    KeyPairIF createKeyPair() throws OperationFailedException;

    String getKeyPairAlgorithm();

    int getKeySize();
}
