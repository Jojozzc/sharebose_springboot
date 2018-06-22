package com.kele.sharebase.utils;

import java.net.InetAddress;

public class HostConfig {

    public static final String DEFAULT_ALIYUN_HOST_NAME = "keleubt";
    public static final String DEFAULT_LOCAL_HOST_NAME = "kele";
    private static String hostName;
    static {
        hostName = DEFAULT_ALIYUN_HOST_NAME;
        try{
            InetAddress addr = InetAddress.getLocalHost();
            hostName = addr.getHostName(); //获取本机计算机名称
            System.out.println("计算机名：" + hostName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getHostName(){
        return hostName;
    }
}
