package com.bootcamp.spring1.integration;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc

public class FlyControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
//    ObjectWriter writer =  new ObjectMapper()
//            .registerModule(new JavaTimeModule()) // convertir fechas
//            .writer();

}
