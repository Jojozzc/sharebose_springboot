package com.kele.sharebase.utils;

import java.security.MessageDigest;

public class MD5Util {
    private MessageDigest md5;
    private static MD5Util instance = new MD5Util();
    private MD5Util(){
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static MD5Util getInstance() {
        return instance;
    }

    public String encodeByMD5(String data)throws Exception{
        return Base64Util.getInstance().encodeToString( md5.digest(data.getBytes()));
    }

}
