package com.example.spring.controllers;

import com.example.spring.repository.MongoDBRepository;
import com.example.spring.repository.MySQLDTORepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    @Autowired
    private MySQLDTORepository mySQLDTORepository;

    @Autowired
    private MongoDBRepository mongoDBRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoadSQL() throws Exception {
        assertThat(mySQLDTORepository).isNotNull();
    }

    @Test
    public void contextLoadMongo() throws Exception {
        assertThat(mongoDBRepository).isNotNull();
    }

    @Test
    void home() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Console")));
    }

    @Test
    void console() throws Exception {
        this.mockMvc.perform(get("/console")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Console")));
    }

    @Test
    void consoleAdd() throws Exception {
        this.mockMvc.perform(get("/console")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Console")));
    }

    @Test
    void file() throws Exception {
        this.mockMvc.perform(get("/file")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("File")));
    }

    @Test
    void mysql() throws Exception {
        this.mockMvc.perform(get("/mysql")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("MySQL")));
    }

    @Test
    void mongodb() throws Exception {
        this.mockMvc.perform(get("/mongodb")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("MongoDB")));
    }
}