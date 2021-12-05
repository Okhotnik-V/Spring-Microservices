package com.example.spring.repository;

import com.example.spring.dtos.MongoDBDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MongoDBRImitationTest {

    @Mock
    MongoDBRepository mongoDBRepository;

    @Test
    public void mongoImitation() {
//        List<MongoDBDTO> mongoDBDTOList = new ArrayList<>();
//        String text = "Okhotnik";
//        mongoDBDTOList.add(new MongoDBDTO(text));
//
//        Mockito.when(mongoDBRepository.findAll()).thenReturn(mongoDBDTOList);
//
//        List<MongoDBDTO> mongoList = mongoDBRepository.findAll();
//        assertEquals(text, mongoList.get(0).textMongoDB);
    }

}