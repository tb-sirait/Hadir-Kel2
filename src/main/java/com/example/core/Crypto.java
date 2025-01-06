package com.example.core;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESLightEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class Crypto {
    private static final String defaultKey = "04f6977af8006071b74319ae25d28a8f4a7e689dad62d2561aedf5c966e5b443";
    public static String performEncrypt(String keyText, String plainText) {
        try{
            byte[] key = Hex.decode(keyText.getBytes());
            byte[] ptBytes = plainText.getBytes();
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESLightEngine()));
            cipher.init(true, new KeyParameter(key));
            byte[] rv = new byte[cipher.getOutputSize(ptBytes.length)];
            int oLen = cipher.processBytes(ptBytes, 0, ptBytes.length, rv, 0);
            cipher.doFinal(rv, oLen);
            return new String(Hex.encode(rv));
        } catch(Exception e) {
            return "Error";
        }
    }

    public static String performEncrypt(String cryptoText) {
        return performEncrypt(defaultKey, cryptoText);
    }

    public static String performDecrypt(String keyText, String cryptoText) {
        try {
            byte[] key = Hex.decode(keyText.getBytes());
            byte[] cipherText = Hex.decode(cryptoText.getBytes());
            BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESLightEngine()));
            cipher.init(false, new KeyParameter(key));
            byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
            int oLen = cipher.processBytes(cipherText, 0, cipherText.length, rv, 0);
            cipher.doFinal(rv, oLen);
            return new String(rv).trim();
        } catch(Exception e) {
            return "Error";
        }
    }

    public static String performDecrypt(String cryptoText) {
        return performDecrypt(defaultKey, cryptoText);
    }

    public static void main(String[] args) {

        String strToEncrypt = "huruhara@3212";//put text to encrypt in here
        String encryptionResult = new Crypto().performEncrypt(strToEncrypt);
        System.out.println("Encryption Result : "+encryptionResult);

//        String strToDecrypt = "5eb279dd4ab4b51e4c8a70d8728ddb20437eaaa1dd2321d98de012117e1a45bb23773123ccae83927e47294c3cfc629fe5fcb9d7b96e093cf7cb7423f90bf96b52f6b8b2e3196075549aa8174cd004cf133f445aa7b4152f5687a8f993c7846592af4d632c8a812e3c2d9d3834d687d35fd2a5b01cc6d1c2a6c5c537ce8794763be4581074436b138ef7bb9a7680748383fd6d7a8fe83b34f8c2199085affc9538b902c2a493ffb8942404468e83fd6d2ac8fc910cc038be0fdca2742b4dc3381e49fbc0f4f14152bc29176bbd009591105ae73a95bc52012a9f4c69fdd00281314c68340ed4a037daddcd85439a8723c70dcffddd5ceba6c67889251555074dc5f2de140a46d86b805c07a679b523cadddce16acd5527e45aa27f1b4cd702f381e7edb32020b77b25f663cba0b162c6";//put text to decrypt in here
//        String decriptionResult = new Crypto().performDecrypt(strToDecrypt);
//        System.out.println("Decryption Result : "+decriptionResult);
    }
}