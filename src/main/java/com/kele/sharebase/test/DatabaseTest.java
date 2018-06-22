package com.kele.sharebase.test;


import com.kele.sharebase.beans.User;
import com.kele.sharebase.dao.UserDao;
import com.kele.sharebase.utils.MD5Util;
import com.kele.sharebase.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

public class DatabaseTest {
//    @Test
    public void originTest()throws Exception{
        /**
         *  1、获得 SqlSessionFactory
         *  2、获得 SqlSession
         *  3、调用在 mapper 文件中配置的 SQL 语句
         */
        SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.queryUserById("admin");
//        sqlSession.commit();
        System.out.println(user);
        System.out.println(user.getNickName());
    }

//    @Test
    public void insertUser()throws Exception{
        String userId = "test2";
        String password = "jdtb231@2";
        String nickName = "test staff2";
        String passwordEncode = MD5Util.getInstance().encodeByMD5(password);
        User user = new User();
        user.setId(userId);
        user.setPassword(passwordEncode);
        user.setNickName(nickName);

        SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int code = userDao.insertUser(user);
        sqlSession.commit();
        System.out.println(code);
    }
//    @Test
    public void updateTest()throws Exception{
        SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.queryUserById("admin");
//        sqlSession.commit();
        System.out.println(user);
        System.out.println(user.getNickName());
        user.setPassword(MD5Util.getInstance().encodeByMD5(user.getPassword()));
        int code = userDao.updateUser(user);
        sqlSession.commit();
        System.out.println(code);
    }

}
