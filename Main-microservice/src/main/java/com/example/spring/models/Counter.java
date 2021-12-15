package com.example.spring.models;

import ch.qos.logback.classic.Logger;
import com.example.spring.interfaces.Counting;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter implements Counting {
    private static final Pattern pattern = Pattern.compile("[" + "a A e E i I o O u U y Y" + "]");

    private static final Logger logger = (Logger) LoggerFactory.getLogger(Counter.class);

    @Override
    public List<String> identify(String textIdentify) {
        try {
            String vowels = "", consonants = "";
            int vowelsQuantity = 0, consonantsQuantity = 0;
            String replace = textIdentify.replaceAll("\\s+", "");
            char[] textToArray = replace.toCharArray();

            for (int i = 0; i < textToArray.length; i++) {
                Matcher matcher = pattern.matcher(String.valueOf(textToArray[i]));
                if (matcher.find()) {
                    vowelsQuantity++;
                    vowels = vowels + String.valueOf(textToArray[i]) + " ";
                } else {
                    consonantsQuantity++;
                    consonants = consonants + String.valueOf(textToArray[i]) + " ";
                }
            }
            List<String> identifyResult = new ArrayList<>();
            identifyResult.add(String.valueOf(vowelsQuantity));
            identifyResult.add(String.valueOf(consonantsQuantity));
            identifyResult.add(vowels);
            identifyResult.add(consonants);
            return identifyResult;
        } catch (Exception e) {
            logger.error("Error: Occurred while checking vowels and consonants");
            return null;
        }
    }
}