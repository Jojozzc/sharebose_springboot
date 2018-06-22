package com.kele.sharebase.test;

import com.kele.sharebase.utils.MD5Util;
import com.kele.sharebase.utils.RSAUtil;
import org.junit.Test;

import java.security.KeyPair;

public class MD5Test {
//    @Test
    public void MD5Test()throws Exception{
        RSAUtil rsaUtil = RSAUtil.getInstance();
        String pw = "jjkk21fadsfadfa3";
        KeyPair keyPair = rsaUtil.generateRSAKeyPair();
        String rsacode = new String(rsaUtil.encrypt(pw, keyPair.getPublic()));
        String md5code = MD5Util.getInstance().encodeByMD5(pw);
        System.out.println(md5code.length());
        System.out.println(md5code);
    }
}
