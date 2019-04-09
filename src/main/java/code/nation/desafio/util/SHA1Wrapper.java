package code.nation.desafio.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Wrapper {

    public static String execute(String frase) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA1");
        return new BigInteger(1, digest.digest(frase.getBytes())).toString(16);
    }

}
