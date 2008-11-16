package se.kth.seds.mi.core.common;

/**
 * @author Shanbo Li
 */
public enum HashAlgorithm {
    MD2("MD2", "MD2withRSA"),
    MD5("MD5", "MD5withRSA"),
    SHA_1("SHA-1", "SHA1withRSA"),
    SHA_256("SHA-256", "SHA256withRSA"),
    SHA_384("SHA-384", "SHA384withRSA"),
    SHA_512("SHA-512", "SHA512withRSA"),;

    private String keyPairAlgorithm;
    private String sharedSecretAlgorithm;

    HashAlgorithm(String sharedSecretAlgorithm, String keyPairAlgorithm) {
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
        return sharedSecretAlgorithm;
    }
}

