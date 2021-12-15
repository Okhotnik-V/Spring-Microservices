package com.example.spring.services;

import com.example.spring.configs.WebSecurityConfig;
import com.example.spring.filters.JwtProviderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    JwtProviderFilter jwtProviderFilter;

    @Autowired
    WebSecurityConfig webSecurityConfig;

    String protocol = "http";
    String domainOauthMicroservice = "localhost:8087";
    String jwtSecret = "okhotnik";
    String token = null;

    public String jwtValidDecode(String jwt) {
        if (jwtProviderFilter.validateToken(jwt, jwtSecret)) {
            return jwtProviderFilter.getLoginFromToken(jwt, jwtSecret);
        } else {
            return null;
        }
    }

    public String validAccessMain(String jwt) {
        token = jwt;
        if (jwtValidDecode(jwt) == null) {
            return "login";
        } else {
            return "redirect:" + protocol + "://" + domainOauthMicroservice + "/oauth2/main/check?check=" + jwt;
        }
    }

    public String confirmationValidAccessMain(String check) {
        String confirmation = jwtValidDecode(check);
        if (confirmation.equals("true")) {
            return login();
        } else {
            return "redirect:main/login";
        }
    }

    public String login() {
        System.out.println("UserToken: " + token + "\n" + "UserDecodeToken: " + jwtProviderFilter.getLoginFromToken(token, jwtSecret));
        Authentication authentication = new UsernamePasswordAuthenticationToken("default", "default");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/main";
    }

}
