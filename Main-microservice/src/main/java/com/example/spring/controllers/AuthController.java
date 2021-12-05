package com.example.spring.controllers;

import com.example.spring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/main/login")
    public String login(String jwt) {
        return authService.validAccessMain(jwt);
    }
    @GetMapping("/main/login/jwt")
    public String getLogin(@RequestParam String jwt) {
        return login(jwt);
    }

    @GetMapping("/main/login/check")
    public String checkLogin(@RequestParam String check) {
        return authService.confirmationValidAccessMain(check);
    }
}
