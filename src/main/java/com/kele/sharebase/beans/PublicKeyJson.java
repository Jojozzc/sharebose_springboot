package com.kele.sharebase.beans;

import com.google.gson.annotations.SerializedName;

public class PublicKeyJson {
    @SerializedName("publicKey")
    private String publicKey;

    public PublicKeyJson(String publicKey){
        this.publicKey = publicKey;
    }
}
