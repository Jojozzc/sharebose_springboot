package com.kele.sharebase.test;

import com.kele.sharebase.utils.Base64Util;
import com.kele.sharebase.utils.RSAUtil;
import org.junit.Test;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSATest {
//    @Test
    public void KeyPairTest(){
        RSAPrivateKey rsaPrivateKey;

        KeyFactory keyFactory = null;
        RSAUtil rsaUtil = RSAUtil.getInstance();
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            keyFactory = KeyFactory.getInstance("RSA");
            KeyPair keyPair = rsaUtil.generateRSAKeyPair();

            PublicKey publicKey = keyPair.getPublic();

            PrivateKey privateKey = keyPair.getPrivate();
            System.out.println("public format" + publicKey.getFormat());
            System.out.println(privateKey.getFormat());

            System.out.println(privateKey.getAlgorithm());
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey.getEncoded());
//            System.out.println(keySpec.getFormat());
//            System.out.println(new String(keySpec.getEncoded(), keySpec.getFormat()));
            RSAPublicKey rsaPublicKey = (RSAPublicKey)publicKey;
            System.out.println(rsaPublicKey.toString());
            System.out.println("公钥:\n" + publicKey.toString());

            System.out.println("私钥:\n" + privateKey.toString());
            byte[] publicKeyByte = publicKey.getEncoded();
            for(byte b : publicKeyByte){
                System.out.println(b);
            }
            String PKCS = new String(rsaUtil.getEncode(publicKey.getEncoded()));
            System.out.println(PKCS);

            String source = "j1235d!@#$%^&*()_+-=";
            System.out.println("原文： " +  source);
            byte[] sourceBytes = source.getBytes("UTF-8");
            for (byte b : sourceBytes)System.out.println(b);
            System.out.println("-----------------");
            // 加密
            byte[] encodeBytes = rsaUtil.encrypt(source.getBytes("UTF-8"), publicKey);
            StringBuilder encodeStr = new StringBuilder();
            String encodeS = new String(encodeBytes, "UTF-8");
            for(byte b : encodeBytes) encodeStr.append((char)b);
            System.out.println("加密后的字符串\n" + encodeS);
//            System.out.println("Base64加密的密文：" + Base64Util.getInstance().decodeToString(encodeStr.toString()));
            // 解密
            byte[] decodeBytes = rsaUtil.decrypt(encodeBytes, privateKey);
            System.out.println("解密后的bytes:");
            StringBuilder res = new StringBuilder();
            for (byte b : decodeBytes) {
                res.append((char)b);
                System.out.println(b);
            }
            System.out.println("复原后的:" + res.toString().trim());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Test
    public void keyTest()throws Exception{// 不成功
//        PublicKey publicKey = new PublicKey() {
//            @Override
//            public String getAlgorithm() {
//                return "RSA";
//            }
//
//            @Override
//            public String getFormat() {
//                return "PKCS#8";
//            }
//
//            @Override
//            public byte[] getEncoded() {
//                return RSAUtil.DEFAULT_PUBLIC_KEY.getBytes();
//            }
//        };
//
//        PrivateKey privateKey = new PrivateKey() {
//            @Override
//            public String getAlgorithm() {
//                return "RSA";
//            }
//
//            @Override
//            public String getFormat() {
//                return "PCKCS#8";
//            }
//
//            @Override
//            public byte[] getEncoded() {
//                return RSAUtil.DEFAULT_PRIVATE_KEY.getBytes();
//            }
//        };
        PrivateKey privateKey;
        String info = "Hi man";
        RSAUtil rsaUtil = RSAUtil.getInstance();
        KeyPair keyPair = rsaUtil.generateRSAKeyPair();
        privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64Util.getInstance().decodeToString(privateKey.getEncoded());
        System.out.println(privateKeyStr);
//        String code = new String(rsaUtil.encrypt(info, publicKey));
//        String afterInfo = new String(rsaUtil.decrypt(code.getBytes(), privateKey));
//        System.out.println(afterInfo);
    }
}
