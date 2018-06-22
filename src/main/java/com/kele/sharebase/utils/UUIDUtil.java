package com.kele.sharebase.utils;

import java.util.UUID;

public class UUIDUtil {
    private static UUIDUtil instance = new UUIDUtil();
    private UUIDUtil(){}

    public static UUIDUtil getInstance() {
        return instance;
    }

    public String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
