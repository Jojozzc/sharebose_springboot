package com.kele.sharebase.service;

import com.google.gson.Gson;
import com.kele.sharebase.beans.PublicKeyJson;
import com.kele.sharebase.utils.Base64Util;
import com.kele.sharebase.utils.RSAUtil;
import org.springframework.web.bind.annotation.*;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;

@RestController
@RequestMapping("/login")
public class LoginService {
    private static RSAUtil rsaUtil = RSAUtil.getInstance();

    private static PublicKey publicKey;

    private static PrivateKey privateKey;

    static {
        try{
            KeyPair keyPair = rsaUtil.generateRSAKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/in", method = RequestMethod.POST)
    public String login(@RequestParam(value = "userId", required = true) String userId,
                        @RequestParam(value = "pw", required = true) String pw){
        System.out.println("login 方法");
        System.out.println(userId);
        System.out.println(pw);
        RSAUtil rsaUtil = RSAUtil.getInstance();
        Base64Util base64Util = Base64Util.getInstance();
        try{
            String userIdStr = new String(rsaUtil.decrypt(base64Util.decodeToBytes(userId.getBytes()), privateKey));
            String password = new String(rsaUtil.decrypt(base64Util.decodeToBytes(pw.getBytes()), privateKey));
            System.out.println("解码后：");
            System.out.println(userIdStr);
            System.out.println(password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "2001";
    }
    @RequestMapping(value = "/publicKey", method = RequestMethod.GET)
    public String getPublicKey(){
        try{
            System.out.println("公钥请求");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(publicKey.getEncoded());
            String publicKeyBase64 = Base64Util.getInstance().encodeToString(keySpec.getEncoded());
            Gson gson = new Gson();

            String json = gson.toJson(new PublicKeyJson(publicKeyBase64));
            System.out.println(json);
            return json;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "神经";
    }

}
