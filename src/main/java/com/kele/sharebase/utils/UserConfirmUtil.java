package com.kele.sharebase.utils;

import com.kele.sharebase.beans.User;

public class UserConfirmUtil {
    private static UserConfirmUtil instance = new UserConfirmUtil();
    private UserConfirmUtil(){}

    public static UserConfirmUtil getInstance() {
        return instance;
    }

    public boolean legalUser(User user){
        /*
        * 密码限定为8位ASCII中的部分可打印字符，不能包括中文，所有字符和约束如下
        1. 所有英文字母（大小写）a-z，A-Z
	    2. 所有数字0-9
	    3. 部分标点 !@#$%^&*()_+-=*
	    4. 密码长度为8~16位，必须至少包含数字和字母*/
        if(user == null) return false;
        String  password = user.getPassword();
        if(password == null || password.length() < 8 || password.length() > 16) return false;
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
}
