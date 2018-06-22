package com.kele.sharebase.beans;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {


    @SerializedName("userId")
    private String id = "";
    @SerializedName("email")
    private String email = "";
    @Expose(serialize = false, deserialize = true)
    private String password = "";
    private String nickName = "";
    private String regTime = "";
    private String phone = "";

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    @Override
    public boolean equals(Object obj){
        if(obj.getClass().equals(User.class)){
            return ((User)obj).getId().equals(this.id);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public String toString(){
        return "User [UserId:" + id + "," + "NickName:" + nickName + ","
                + "email:" + email + "," + "register time:" + regTime + "]";
    }
}
