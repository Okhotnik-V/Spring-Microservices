package com.example.spring.repository;

import com.example.spring.dtos.MySQLDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MySQLDTOImitationTest {

    @Mock
    MySQLDTORepository mySQLDTORepository;

    @Test
    public void mySQLImitation() {
        MySQLDTO mySQLDTO = new MySQLDTO();
        List<MySQLDTO> mySQLDTOList = new ArrayList<>();
        String text = "Okhotnik";

        mySQLDTO.setText(text);
        mySQLDTOList.add(mySQLDTO);

        Mockito.when(mySQLDTORepository.findAll()).thenReturn(mySQLDTOList);

        List<MySQLDTO> mySQLList = (List<MySQLDTO>) mySQLDTORepository.findAll();
        assertEquals(text, mySQLList.get(0).getText());
    }
}