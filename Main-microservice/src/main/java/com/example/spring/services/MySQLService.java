package com.example.spring.services;

import ch.qos.logback.classic.Logger;
import com.example.spring.dtos.MySQLDTO;
import com.example.spring.repository.MySQLDTORepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MySQLService.class);

    MySQLDTO mySQLDTO = new MySQLDTO();

    @Autowired
    private MySQLDTORepository mySQLDTORepository;

    @Cacheable("ehCacheMySQL")
    public String getTextSQL() {
        logger.info("Getting from MySQL");
        List<MySQLDTO> sqldtoList = (List<MySQLDTO>) mySQLDTORepository.findAll();
        return sqldtoList.get(0).text;
    }

    @Cacheable("ehCacheMySQL")
    public String getText(String textMySQL) {
        if (mySQLDTORepository.findByText(textMySQL) == null) {
            logger.info("Save text MySQL");
            mySQLDTO.setText(textMySQL);
            mySQLDTORepository.save(mySQLDTO);
        }
        return textMySQL;
    }
}
