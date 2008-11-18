package se.kth.seds.mi.core.crypto.keypair;

import org.apache.catalina.util.HexUtils;

import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;

/**
 * @author Shanbo Li
 */
public class RSAKeyPair {
    private final KeyPair keyPair;

    public RSAKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public String getPublicKeyInString() {
        return HexUtils.convert(keyPair.getPublic().getEncoded());
    }

    public String getPrivateKeyInString() {
        return HexUtils.convert(keyPair.getPrivate().getEncoded());
    }

    public PublicKey getPublicKey(){
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey(){
        return keyPair.getPrivate();
    }

    public String getKeyPairAlgorithm() {
        return "RSA";
    }

    public int getKeySize() {
        return 1024;
    }

}
