package com.example.spring.services;

import ch.qos.logback.classic.Logger;
import com.example.spring.dtos.MongoDBDTO;
import com.example.spring.repository.MongoDBRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MongoDBService.class);
    MongoDBDTO mongoDBDTO = new MongoDBDTO();

    @Autowired
    private MongoDBRepository mongoDBRepository;

    @Cacheable("ehCacheMongoDB")
    public String getTextMongo() {
        logger.info("Getting from MongoDB");

        try {
            List<MongoDBDTO> dbdtoList = mongoDBRepository.findAll();
            return dbdtoList.get(0).textMongoDB;
        } catch (Exception e) {
            addText();
            return getTextMongo();
        }
    }

    private void addText() {
        logger.info("set mongoDBDTO");
        mongoDBDTO.setTextMongoDB("MongoDB");
        mongoDBRepository.save(mongoDBDTO);
        getTextMongo();
    }
}
