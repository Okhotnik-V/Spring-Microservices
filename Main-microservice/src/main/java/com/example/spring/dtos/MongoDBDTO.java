package com.example.spring.dtos;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import javax.persistence.Id;

@Getter
@Setter
public class MongoDBDTO {
    @Id
    public ObjectId id;
    public String textMongoDB;
}