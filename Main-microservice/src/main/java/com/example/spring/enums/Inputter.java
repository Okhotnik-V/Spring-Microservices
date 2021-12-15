package com.example.spring.enums;

public enum Inputter {
    CONSOLE("Console"), FILE("File"), DB("Database");

    private final String inputer;

    Inputter(String inputer) {
        this.inputer = inputer;
    }

    public String getInputer() {
        return inputer;
    }
}


