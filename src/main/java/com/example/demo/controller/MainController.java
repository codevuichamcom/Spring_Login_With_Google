package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.TokenUtils;

@RestController
public class MainController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/login-google")
    public String loginGoogle(@AuthenticationPrincipal OAuth2User principal) {

        String email = principal.getAttribute("email");

        return TokenUtils.generateToken(email);
    }

    // có thể logout với url /logout hoặc login?logout

    @GetMapping("/user")
    public OAuth2User user(@AuthenticationPrincipal OAuth2User principal) {

        return principal;
    }

}
