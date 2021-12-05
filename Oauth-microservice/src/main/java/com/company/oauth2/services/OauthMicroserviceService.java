package com.company.oauth2.services;

import com.company.oauth2.filters.JwtProviderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class OauthMicroserviceService {

    @Autowired
    JwtProviderFilter jwtProviderFilter;

    String protocol = "http";
    String domainMainMicroservice = "localhost:8088";
    String jwtSecret = "okhotnik";

    public String setJWT(String user) {
        String token;
        token = jwtProviderFilter.generateToken(user, jwtSecret);
        if (jwtProviderFilter.validateToken(token, jwtSecret)) {
            return token;
        } else {
            return null;
        }
    }

    public String authorized(Principal user) {
        return setJWT(String.valueOf(user));
    }

    public String checkLogin(String check, Principal user) {
        boolean valid;

        String tokenOauth = jwtProviderFilter.getLoginFromToken(authorized(user), jwtSecret);
        String tokenMicroservice = jwtProviderFilter.getLoginFromToken(check, jwtSecret);
        if (tokenOauth.equals(tokenMicroservice)) {
            valid = true;
        } else {
            valid = false;
        }
        return setJWT(String.valueOf(valid));
    }

    public String AuthorizedMain(Principal user) {
        return "redirect:" + protocol + "://" + domainMainMicroservice + "/main/login/jwt?jwt=" + authorized(user);
    }

    public String checkLoginMain(String check, Principal user) {
        return "redirect:" + protocol + "://" + domainMainMicroservice + "/main/login/check?check=" + checkLogin(check, user);
    }
}
