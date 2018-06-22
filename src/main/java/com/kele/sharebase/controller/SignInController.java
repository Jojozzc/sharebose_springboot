package com.kele.sharebase.controller;

import com.google.gson.Gson;
import com.kele.sharebase.beans.User;
import com.kele.sharebase.body.SignInResponseBody;
import com.kele.sharebase.dao.UserDao;
import com.kele.sharebase.utils.Base64Util;
import com.kele.sharebase.utils.MD5Util;
import com.kele.sharebase.utils.MybatisUtil;
import com.kele.sharebase.utils.RSAUtil;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/signIn")
@RestController
public class SignInController {
    private static RSAUtil rsaUtil = RSAUtil.getInstance();
    private static Gson gson = new Gson();
    @PostMapping("")
    public String signIn(@RequestParam(value = "userId") String userId,
                               @RequestParam(value = "password") String password){
        // 解码
        System.out.println("---------------------------登录请求---------------------------");
        SignInResponseBody responseBody = new SignInResponseBody();
        boolean isDecode = true;
        User user = new User();
        if(userId == null || password == null){
            responseBody.setCode(4002);
            responseBody.setMessage("缺少必要参数");
            System.out.println("缺少必要参数");
        }
        else {
            try {

                // 解码
                password = new String(rsaUtil.decrypt(Base64Util.getInstance().decodeToBytes(password.getBytes()), rsaUtil.getDefaultPrivate()));
                userId = new String(rsaUtil.decrypt(Base64Util.getInstance().decodeToBytes(userId.getBytes()), rsaUtil.getDefaultPrivate()));
            }catch (Exception e){
                isDecode = false;
                e.printStackTrace();
                responseBody.setCode(5001);
                responseBody.setMessage("解码错误");
            }
            if(isDecode){
                boolean isMd5Ok = true;
                try{
                    password = MD5Util.getInstance().encodeByMD5(password);
                }catch (Exception e){
                    e.printStackTrace();
                    isMd5Ok = false;
                    responseBody.setCode(5001);
                    responseBody.setMessage("查询失败");
                }
                if(isMd5Ok){
                    try{
                        SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
                        UserDao userDao = sqlSession.getMapper(UserDao.class);
                        user = userDao.queryUserById(userId);
                        sqlSession.commit();
                        if(user == null){
                            responseBody.setCode(6005);
                            responseBody.setMessage("账号不存在");
                        }
                        else {
                            if(password.equals(password)){
                                responseBody.setCode(2001);
                                responseBody.setUser(user);
                            }else {
                                responseBody.setCode(4001);
                                responseBody.setMessage("密码错误");
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        responseBody.setCode(5001);
                        responseBody.setMessage("数据库错误");
                    }
                }
            }
        }

        return gson.toJson(responseBody);

    }
}
