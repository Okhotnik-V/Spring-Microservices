package com.example.spring.dtos;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import javax.persistence.Id;

@Getter
@Setter
public class StatisticsDTO {
    @Id
    private ObjectId id;
    private int vowelsNumber;
    private int consonantsNumber;
    private int inspections;
    private String vowels;
    private String consonants;
    private String line;
    private String typeInput;
    private String timestamp;
}
