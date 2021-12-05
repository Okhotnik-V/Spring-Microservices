package com.example.spring.repository;

import com.example.spring.dtos.MongoDBDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoDBRepository extends MongoRepository<MongoDBDTO, ObjectId> {
}
