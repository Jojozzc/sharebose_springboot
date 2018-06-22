package com.kele.sharebase.body;

import com.kele.sharebase.beans.User;

public class SignInResponseBody extends BaseResponseBody {
    private User user;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        if(user == null)
            return "user : null" + super.toString();
        else return user.toString() + super.toString();
    }
}
