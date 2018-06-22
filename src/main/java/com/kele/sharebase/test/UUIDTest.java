package com.kele.sharebase.test;

import com.kele.sharebase.utils.UUIDUtil;
import org.junit.Test;

public class UUIDTest {
//    @Test
    public void uuid(){
        String uuid = UUIDUtil.getInstance().getUUID();
        System.out.println(uuid.length());
        System.out.println(uuid);
    }
}
