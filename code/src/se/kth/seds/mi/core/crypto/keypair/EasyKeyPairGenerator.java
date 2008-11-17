package se.kth.seds.mi.core.crypto.keypair;

import org.apache.catalina.util.HexUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.Serializable;

import se.kth.seds.mi.core.exceptions.OperationFailedException;
import se.kth.seds.mi.core.common.HashAlgorithm;

/**
 * A key pair generator.
 * It use RSA to generate a key pair. Key size = 1024
 *
 * @author Shanbo Li
 */
public class EasyKeyPairGenerator implements Serializable{
    private KeyPair keyPair;
    private static final long serialVersionUID = 5518257265383126473L;
    public final Log logger = LogFactory.getLog(getClass());

    public EasyKeyPairGenerator() {
    }

    public void init() throws OperationFailedException {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPair = keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            logger.error("Can not get RSA algrothm, check if your JRE installed correctly...",e);
            throw new OperationFailedException(e);
        }
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    public String getPublicKeyInString() {
        return HexUtils.convert(keyPair.getPublic().getEncoded());
    }

    public String getPrivateKeyInString() {
        return HexUtils.convert(keyPair.getPrivate().getEncoded());
    }

    public String getAlgorithm() {
        return "RSA";
    }

    public int getKeySize() {
        return 1024;
    }
}

