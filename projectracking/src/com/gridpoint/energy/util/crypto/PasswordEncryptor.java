package com.gridpoint.energy.util.crypto;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class PasswordEncryptor {

    private final static String algorithm = "AES";
    private final static String charsetName = "UTF8";

    private boolean env;
    private String keyName;
    private String key;

    public boolean isEnv() {
        return env;
    }

    public void setEnv(boolean env) {
        this.env = env;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Password encrypted. This will taken only plain text password and
     * converted into encrypted password and key will reading from
     * system/gpup.properties environment variable.
     * 
     * @param password
     * @return
     * @throws Exception
     */
    public String encrypt(String password) throws Exception {
        
        byte[] masterKey = getKey().getBytes();
        SecretKeySpec spec = new SecretKeySpec(masterKey, algorithm);

        Cipher ecipher = Cipher.getInstance(algorithm);
        ecipher.init(Cipher.ENCRYPT_MODE, spec);

        byte[] utf8 = password.getBytes(charsetName);
        byte[] enc = ecipher.doFinal(utf8);

        return DatatypeConverter.printBase64Binary(enc);
    }

    /**
     * Password decrypted. This will taken only encrypted password and converted
     * into plain text password and key will reading from system
     * environment/gpup.properties variable.
     * 
     * @param password
     * @return
     * @throws Exception
     */
    public String decrypt(String password) throws Exception {

        String key = isEnv() == true ? System.getenv(keyName) : this.key;

        if (key == null || key.equals("")) {
            if (isEnv()) {
                throw new Exception("MASTER_KEY MassCEC Enviornment variable value is NULL");
            } else {
                throw new Exception("Unable to get MassCEC key from gpup.properties");
            }

        }
        byte[] masterKey = key.getBytes();
        SecretKeySpec spec = new SecretKeySpec(masterKey, algorithm);
        Cipher dcipher = Cipher.getInstance(algorithm);
        dcipher.init(Cipher.DECRYPT_MODE, spec);

        byte[] dec = DatatypeConverter.parseBase64Binary(password);
        byte[] utf8 = dcipher.doFinal(dec);
        return new String(utf8, charsetName);
    }

    public static void main(String[] args) throws Exception {
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();
        Scanner userInput = new Scanner(System.in);
        String key = "";
        // Master key entry if master key not satisfied 128 bit then again read
        // from user
        do {
            System.out.println("Enter Master Key: ");
            key = userInput.next();
        } while (!validateKey(key));
        passwordEncryptor.setKey(key);
        // Password reading...
        System.out.println("Enter Plain Text Password");
        String password = userInput.next();

        String encryptPassword = passwordEncryptor.encrypt(password);
        System.out.println(encryptPassword);
    }

    private static boolean validateKey(String key) {
        byte[] keyBytes = key.getBytes();
        if (keyBytes.length == 16) {                   
            return true;
        } else {
            System.out.println("Key is invalid: ");
        }
        return false;
    }
}
