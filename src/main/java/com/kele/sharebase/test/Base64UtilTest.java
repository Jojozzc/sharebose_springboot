package com.kele.sharebase.test;

import com.kele.sharebase.utils.Base64Util;
import org.junit.Test;

public class Base64UtilTest {
    Base64Util base64Util = Base64Util.getInstance();
//    @Test
    public void base64Test(){
        try{
            String source = "hi my brother";
            String decodeStr = base64Util.encodeToString(source);
            System.out.println("明文：" + source);
            System.out.println("密文：" + decodeStr);
            System.out.println("解密后：" + base64Util.decodeToString(decodeStr));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
