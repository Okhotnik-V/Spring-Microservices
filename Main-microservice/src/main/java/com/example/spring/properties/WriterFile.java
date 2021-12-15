package com.example.spring.properties;

import ch.qos.logback.classic.Logger;
import com.example.spring.interfaces.WritingFile;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class WriterFile implements WritingFile {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(WriterFile.class);

    @Override
    public String write(String textWrite) {
        try (FileWriter fileWriter = new FileWriter("Result.txt", false)) {
            fileWriter.write(String.valueOf(textWrite));
            fileWriter.flush();
        } catch (IOException ex) {
            logger.error("Write error.");
        }
        return textWrite;
    }
}