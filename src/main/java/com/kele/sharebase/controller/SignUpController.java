package com.kele.sharebase.controller;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.kele.sharebase.beans.User;
import com.kele.sharebase.dao.UserDao;
import com.kele.sharebase.utils.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.PrivateKey;

@RequestMapping(value = "/signUp")
@RestController
public class SignUpController {
    private static RSAUtil rsaUtil = RSAUtil.getInstance();
    private static Gson gson = new Gson();
    private static Base64Util base64Util = Base64Util.getInstance();
    @PostMapping(value = "")
    public String signUp(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "nickName") String nickName,
            @RequestParam(value = "password") String password){

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------------注册请求---------------------------");
        System.out.println(TimeUtil.getInstance().getNowDateAndTime());
        System.out.println("userId :" + userId);
        System.out.println("nickName:" + nickName);
        System.out.println("password:" + password);
        ResponseBody responseBody = new ResponseBody();
        PrivateKey privateKey = RSAUtil.getInstance().getDefaultPrivate();

        if(userId == null || nickName == null || password == null){
            responseBody.setCode(4002);
            responseBody.setMessage("缺少必要参数");
            return gson.toJson(responseBody);
        }
//        password = password.replaceAll("\\s", "+");
//        nickName = nickName.replaceAll("\\s", "+");
//        userId = userId.replaceAll("\\s", "+");

        System.out.println("处理后password：" + password);
        String realPw = null;
        try{
            password
                    = new String(rsaUtil.decrypt(base64Util.decodeToBytes(password.getBytes()), privateKey));
            userId = new String(rsaUtil.decrypt(base64Util.decodeToBytes(userId.getBytes()), privateKey));
            nickName = new String(rsaUtil.decrypt(base64Util.decodeToBytes(nickName.getBytes()), privateKey));
        }catch (Exception e){
            System.out.println("解码失败");
            e.printStackTrace();
            responseBody.setCode(4002);
            responseBody.setMessage("密码加密方式错误");
            return gson.toJson(responseBody);
        }

        User user = new User();
        user.setId(userId);
        user.setNickName(nickName);

        if(legalUser(user, password)){
            SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            User useri = userDao.queryUserById(user.getId());
            User userByNickName = userDao.queryUserByNickName(user.getNickName());
            sqlSession.commit();
            if(useri != null){
                // 已经存在用户
                responseBody.setCode(6003);
                responseBody.setMessage("id重复");
            }
            else {
                if(userByNickName != null){
                    responseBody.setCode(6003);
                    responseBody.setMessage("nickName重复");
                }
                else{
                    try{

                        user.setPassword(MD5Util.getInstance().encodeByMD5(password));
                        userDao.insertUser(user);
                        responseBody.setCode(2001);
                        responseBody.setUser(user);
                        sqlSession.commit();
                    }catch (Exception e){
                        e.printStackTrace();
                        responseBody.setUser(null);
                        responseBody.setCode(5001);
                        return gson.toJson(responseBody);
                    }
                }
            }
        }
        else {
            responseBody.setCode(5001);
        }
        System.out.println();
        return gson.toJson(responseBody);
    }

    private boolean legalUser(User user, String password){
        /*
        * 密码限定为8位ASCII中的部分可打印字符，不能包括中文，所有字符和约束如下
        1. 所有英文字母（大小写）a-z，A-Z
	    2. 所有数字0-9
	    3. 部分标点 !@#$%^&*()_+-=*
	    4. 密码长度为8~16位，必须至少包含数字和字母*/
        if(user == null || password == null || password.length() < 8 || password.length() > 16) return false;
        for(int i = 0; i < password.length(); i++){
            if(!charMatch(password.charAt(i)))return false;
        }
        return true;
    }

    private boolean charMatch(char ch){
        if(ch >= 'a' && ch <= 'z')return true;
        if(ch >= '0' || ch <= '9')return true;
        if(ch == '!' || ch == '@' || ch == '$'
                || ch == '%' || ch == '^' || ch == '&' || ch == '*'
                || ch == '(' || ch == ')' || ch == '-' || ch == '_' || ch == '=' || ch == '+')
            return true;
        return false;
    }


    class ResponseBody{
        @SerializedName("code")
        private int code = 5001;
        @SerializedName("user")
        private User user;

        private String message = "";


        public void setCode(int code) {
            this.code = code;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}
