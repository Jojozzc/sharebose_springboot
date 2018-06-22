package com.kele.sharebase.test;

import org.junit.Test;

import java.net.InetAddress;

public class HostTest {
//    @Test
    public void hostNameTest(){
        try{
            InetAddress addr = InetAddress.getLocalHost();
            String ip=addr.getHostAddress(); //获取本机ip
            String hostName=addr.getHostName(); //获取本机计算机名称
            System.out.println(ip);
            System.out.println(hostName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
