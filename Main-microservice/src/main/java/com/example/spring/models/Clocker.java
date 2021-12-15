package com.example.spring.models;

import com.example.spring.interfaces.Clocking;

import java.sql.Timestamp;

public class Clocker implements Clocking {

    @Override
    public Timestamp getTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }
}
