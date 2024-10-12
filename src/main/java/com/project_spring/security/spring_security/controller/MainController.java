package com.project_spring.security.spring_security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticated(Authentication authentication){
        return "Authenticated Web page " + authentication.getName();
    }
}
