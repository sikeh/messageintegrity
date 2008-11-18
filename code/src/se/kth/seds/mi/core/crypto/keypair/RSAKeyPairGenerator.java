package se.kth.seds.mi.core.crypto.keypair;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import se.kth.seds.mi.core.exceptions.OperationFailedException;

/**
 * A key pair generator.
 * It use RSA to generate a key pair. Key size = 1024
 *
 * @author Shanbo Li
 */
public class RSAKeyPairGenerator {
    public static RSAKeyPair createKeyPair() throws OperationFailedException {
         try {
             KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
             KeyPair keyPair = keyPairGenerator.genKeyPair();
             return new RSAKeyPair(keyPair);
        } catch (NoSuchAlgorithmException e) {
             Log logger = LogFactory.getLog(RSAKeyPairGenerator.class.getName());
            logger.error("Can not get RSA algrothm, check if your JRE installed correctly...",e);
            throw new OperationFailedException(e);
        }
    }

    public String getKeyPairAlgorithm() {
        return "RSA";
    }

    public int getKeySize() {
        return 1024;
    }
}

