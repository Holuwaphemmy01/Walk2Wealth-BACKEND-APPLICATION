package com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.encryptAndDecrypt;


import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class EncryptionAndDecryption {

    private final static String ALGORITHM = "AES/CBC/PKCS5Padding";
    private final static int KEY_SIZE = 256;
    private final static int ITERATIONS = 65536;
    private final static int SALT_LENGTH = 16;
    private final static int IV_LENGTH = 16;

    public static String encryptPrivateKey(String privateKey, String password) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        byte[] iv = new byte[IV_LENGTH];
        secureRandom.nextBytes(salt);
        secureRandom.nextBytes(iv);

        SecretKey secretKey = getSecretKey(password, salt);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] encryptedBytes = cipher.doFinal(privateKey.getBytes());

        return  Base64.getEncoder().encodeToString(salt) + ":" +
                Base64.getEncoder().encodeToString(iv) + ":" +
                Base64.getEncoder().encodeToString(encryptedBytes);
    }


    public static String decryptPrivateKey(String encryptedData, String password) throws Exception {
        String[] parts = encryptedData.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] iv = Base64.getDecoder().decode(parts[1]);
        byte[] encryptedBytes = Base64.getDecoder().decode(parts[2]);

        SecretKey secretKey = getSecretKey(password, salt);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);


        return new String(decryptedBytes);
    }

    private static SecretKey getSecretKey(String password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_SIZE);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }


}
