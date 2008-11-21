package se.kth.seds.mi.core.crypto.keypair.rsa;

import org.apache.catalina.util.HexUtils;

import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;

import se.kth.seds.mi.core.crypto.keypair.KeyPairIF;

/**
 * @author Shanbo Li
 */
public class RSAKeyPair implements KeyPairIF {
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
