package se.kth.seds.mi.core.crypto.keypair;

import java.security.PublicKey;
import java.security.PrivateKey;

/**
 * @author Shanbo Li
 */
public interface KeyPairIF {
    String getPublicKeyInString();

    String getPrivateKeyInString();

    PublicKey getPublicKey();

    PrivateKey getPrivateKey();

    String getKeyPairAlgorithm();

    int getKeySize();
}
