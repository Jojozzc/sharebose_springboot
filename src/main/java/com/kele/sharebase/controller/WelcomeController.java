package com.kele.sharebase.controller;

import com.kele.sharebase.beans.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping(value = "/")
    public String hello(){
        return "Welcome to Sharebase";
    }
}
