package se.kth.seds.mi.core.keypair;

import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author Shanbo Li
 */
public interface KeyPairCrypto {
    public String getMessage();

    public void setMessage(String message);

    public HashAlgorithm getHashAlgorithm();

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm);

    public String sign(PrivateKey priv) throws OperationFailedException;

    public boolean verify(PublicKey publicKey, String mac) throws OperationFailedException;
}
