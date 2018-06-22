package com.kele.sharebase.body;

import com.google.gson.annotations.SerializedName;
import com.kele.sharebase.beans.User;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;

public class BaseResponseBody  {

    private int code = 5001;

    private String message = "";


    public void setCode(int code) {
        this.code = code;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "[Code:" + code + ", message:" + message + "]";
    }

}
