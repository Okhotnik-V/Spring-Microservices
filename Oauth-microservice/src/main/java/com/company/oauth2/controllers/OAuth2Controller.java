package com.company.oauth2.controllers;

import com.company.oauth2.dtos.User;
import com.company.oauth2.services.OauthMicroserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.HashMap;

@Controller
public class OAuth2Controller {

    @Autowired
    OauthMicroserviceService oauthMicroserviceService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile", user);
        model.addAttribute("frontendData", data);
        return "start";
    }

    @GetMapping("/oauth2/main")
    public String authorized_main(Principal user) {
        return oauthMicroserviceService.AuthorizedMain(user);
    }

    @GetMapping("/oauth2/main/check")
    public String authorized_main_check(@RequestParam String check, Principal user) {
        return oauthMicroserviceService.checkLoginMain(check, user);
    }
}
