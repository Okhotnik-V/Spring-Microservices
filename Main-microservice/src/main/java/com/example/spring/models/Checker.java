package com.example.spring.models;

import ch.qos.logback.classic.Logger;
import com.example.spring.interfaces.Checking;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Checker implements Checking {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(Checker.class);

    @Override
    public String determine(String textDetermine) {
        boolean correct = false;

        try {
            boolean resultDetermine;
            if (textDetermine != null && !textDetermine.trim().isEmpty()) {
                resultDetermine = Pattern.matches("[" + "a-z A-Z" + "]" + "*", textDetermine);
                return textDetermine;
            } else {
                resultDetermine = false;
                logger.error("Error, a sentence is entered that does not meet the requirements");
                return null;
            }
        } catch (Exception e) {
            logger.error("Error: Occurred while checking text.");
            return null;
        }
    }
}