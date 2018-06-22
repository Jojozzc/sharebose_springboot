package com.kele.sharebase.controller;

import clojure.lang.IFn;
import com.google.gson.Gson;
import com.kele.sharebase.beans.PublicKeyJson;
import com.kele.sharebase.utils.Base64Util;
import com.kele.sharebase.utils.RSAUtil;
import com.kele.sharebase.utils.TimeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
@RestController
@RequestMapping("/security")
public class SecurityController {
    private static String DEFAULT_PUBLIC_KEY_JSON;
    static {
        PublicKey publicKey = RSAUtil.getInstance().getDefaultPublic();

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(publicKey.getEncoded());
        String publicKeyBase64 = Base64Util.getInstance().encodeToString(keySpec.getEncoded());
        Gson gson = new Gson();
        DEFAULT_PUBLIC_KEY_JSON = gson.toJson(new PublicKeyJson(publicKeyBase64));
    }
    @GetMapping("/publicKey")
    public String getPublicKey(){
        System.out.println("---------------------------公钥请求---------------------------");
        System.out.println(TimeUtil.getInstance().getNowDateAndTime());
        System.out.println("---------------------------公钥请求---------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        return DEFAULT_PUBLIC_KEY_JSON;
    }
}
