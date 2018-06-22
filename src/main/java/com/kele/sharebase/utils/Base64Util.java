package com.kele.sharebase.utils;

import java.util.Base64;

public class Base64Util {
    private static Base64Util instance = new Base64Util();
    private Base64Util(){};

    private static Base64.Decoder decoder;
    private static Base64.Encoder encoder;
    public static Base64Util getInstance() {
        decoder = Base64.getDecoder();
        encoder = Base64.getEncoder();
        return instance;
    }
    public String encodeToString(String source, String charsetName)throws Exception{
        if(source == null || charsetName == null) throw new Exception("Param should not be null");
        return encoder.encodeToString(source.getBytes(charsetName));
    }
    public String encodeToString(String source)throws Exception{
        return encodeToString(source, "UTF-8");
    }

    public String decodeToString(String code, String charsetName)throws Exception{
        if(code == null || charsetName == null) throw new Exception("Param should not be null");
        return new String(decoder.decode(code), charsetName);
    }

    public String decodeToString(String code)throws Exception{
        return decodeToString(code, "UTF-8");
    }
    public String decodeToString(byte[] data) throws Exception{
        return new String(decoder.decode(data));
    }

    public String encodeToString(byte[] data){
        return encoder.encodeToString(data);
    }

    public byte[] decodeToBytes(byte[] data){
        return decoder.decode(data);
    }
}
