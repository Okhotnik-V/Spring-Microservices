package com.company.oauth2.filters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtProviderFilterTest {

    JwtProviderFilter jwtProvider = new JwtProviderFilter();
    String jwtSecret = "okhotnik";
    String text = "Okhotnik";
    String token;
    String tokenText;
    boolean tokenValid;

    @Test
    public void createTest() {
        token = jwtProvider.generateToken(text, jwtSecret);
        tokenValid = jwtProvider.validateToken(text, jwtSecret);
        tokenText = jwtProvider.getLoginFromToken(token, jwtSecret);

        assertEquals(tokenValid,false);
        assertEquals(text,tokenText);
        System.out.println(tokenValid);
        System.out.println(tokenText);
    }
}