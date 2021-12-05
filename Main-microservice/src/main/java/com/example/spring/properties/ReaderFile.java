package com.example.spring.properties;

import ch.qos.logback.classic.Logger;
import com.example.spring.interfaces.ReadingFile;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderFile implements ReadingFile {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ReaderFile.class);

    @Override
    public String read() {
        String fileName = "Text.txt";
        String textRead = null;
        try {
            textRead = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            logger.error("Read error. Change the content (file type).");
        }
        return textRead;
    }
}
