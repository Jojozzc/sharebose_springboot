package com.kele.sharebase.dao;

import com.kele.sharebase.beans.User;

import java.util.List;

public interface UserDao {
    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(User user);

    public User queryUserById(String userId);

    public List<User> queryAllUser();

    public User queryUserByNickName(String nickName);
}
