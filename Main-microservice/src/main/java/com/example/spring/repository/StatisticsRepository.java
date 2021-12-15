package com.example.spring.repository;

import com.example.spring.dtos.StatisticsDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends MongoRepository<StatisticsDTO, ObjectId> {
    StatisticsDTO findByLine(String line);
}
