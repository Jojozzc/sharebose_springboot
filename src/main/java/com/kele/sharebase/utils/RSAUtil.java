package com.kele.sharebase.utils;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class RSAUtil {
    private static KeyPair DEFAULT_KEY_PAIR;
    public static final String DEFAULT_FORMAT = "PKCS#8";
    private static final String ALGORITHM = "RSA";
    private static final int KEY_SIZE = 1024;
    private static RSAUtil instance = new RSAUtil();
    private RSAUtil(){
        try{
            KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
            generator.initialize(KEY_SIZE);
            DEFAULT_KEY_PAIR = generator.genKeyPair();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static RSAUtil getInstance() {
        return instance;
    }

    public KeyPair generateRSAKeyPair() throws Exception{
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
        generator.initialize(KEY_SIZE);
        KeyPair keyPair = generator.generateKeyPair();
        return keyPair;
    }

    public byte[] encrypt(byte[] sourceBytes, PublicKey publicKey)throws Exception{
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(sourceBytes);
    }
    public byte[] encrypt(String source, PublicKey publicKey)throws Exception{
        // 加密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] sourceBytes = source.getBytes();
        return cipher.doFinal(sourceBytes);
    }
    public byte[] encrypt(String source)throws Exception{
        return encrypt(source, DEFAULT_KEY_PAIR.getPublic());
    }

    public byte[] decrypt(byte[] data, PrivateKey privateKey)throws Exception{
        // 解密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");// RSA/ECB/NoPadding
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    public byte[] decrypt(byte[] data)throws Exception{
        return decrypt(data, DEFAULT_KEY_PAIR.getPrivate());
    }

    public byte[] getEncode(byte[] encodeData){
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(encodeData);
        return pkcs8EncodedKeySpec.getEncoded();
    }

    public PublicKey getDefaultPublic(){
        return DEFAULT_KEY_PAIR.getPublic();
    }

    public PrivateKey getDefaultPrivate(){
        return DEFAULT_KEY_PAIR.getPrivate();
    }
}
