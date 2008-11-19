package se.kth.seds.mi.core.common;

/**
 * @author Shanbo Li
 */
public enum HashAlgorithm {
    MD2("MD2", "MD2withRSA"),
    MD5("MD5", "MD5withRSA"),
    SHA1("SHA-1", "SHA1withRSA"),
    SHA256("SHA-256", "SHA256withRSA"),
    SHA384("SHA-384", "SHA384withRSA"),
    SHA512("SHA-512", "SHA512withRSA"),;

    private final String keyPairAlgorithm;
    private final String sharedSecretAlgorithm;

    HashAlgorithm(final String sharedSecretAlgorithm, final String keyPairAlgorithm) {
        this.sharedSecretAlgorithm = sharedSecretAlgorithm;
        this.keyPairAlgorithm = keyPairAlgorithm;
    }

    public String getKeyPairAlgorithm() {
        return keyPairAlgorithm;
    }

    public String getSharedSecretAlgorithm() {
        return sharedSecretAlgorithm;
    }

    @Override
    public String toString(){
        return sharedSecretAlgorithm.replace("-","");
    }
   
}

