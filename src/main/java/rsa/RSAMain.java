package rsa;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author Dauren Mussa
 * @since 4/25/18
 */
public class RSAMain {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {

        long time1 = System.nanoTime();
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(4096);
        KeyPair keys = gen.generateKeyPair();
        long time2 = System.nanoTime();
        System.out.println("GEN: " + (time2 - time1));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keys.getPublic());
        String text = "Daka is working hard!";
        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));

        long time3 = System.nanoTime();
        System.out.println("ENCRYPT: " + (time3 - time2));

        System.out.println(text);
        System.out.println(new String(encrypted));

        Cipher decrypt = Cipher.getInstance("RSA");
        decrypt.init(Cipher.DECRYPT_MODE, keys.getPrivate());
        byte[] decrypted = decrypt.doFinal(encrypted);

        long time4 = System.nanoTime();

        System.out.println("DECRYPT: " + (time4 - time3));

        String text2 = new String(decrypted);
        System.out.println(text2);


    }

}
