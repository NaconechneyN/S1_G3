package com.bootcamp.spring1.integration;

import com.bootcamp.spring1.entity.Flight;
import com.bootcamp.spring1.utils.FlyFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class FlyControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.INDENT_OUTPUT, false)
            .registerModule(new JavaTimeModule())
            .writer();
    @Test
     void mktFlightsTest() throws Exception {
        //arrange
        List<Flight> expected = List.of(FlyFactory.getFly1(),
                FlyFactory.getFly2(),
                FlyFactory.getFly3(),
                FlyFactory.getFly4(),
                FlyFactory.getFly5(),
                FlyFactory.getFly6(),
                FlyFactory.getFly7(),
                FlyFactory.getFly8(),
                FlyFactory.getFly9(),
                FlyFactory.getFly10(),
                FlyFactory.getFly11(),
                FlyFactory.getFly12());

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/flights/mkt");

        //Expected --> Status, body y contentype
        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //Body
        ResultMatcher bodyExpected;
        bodyExpected = MockMvcResultMatchers.content().json(
                writer.writeValueAsString(expected)
        );


        System.out.println(writer.writeValueAsString(expected));
        //contentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //Act&assert con mocking
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
    @Test
    void findByOrderByFlightPriceAsc() throws Exception {
        //arrange
        List<Flight> expected = List.of(FlyFactory.getFly1(),
                FlyFactory.getFly2(),
                FlyFactory.getFly3(),
                FlyFactory.getFly4(),
                FlyFactory.getFly5(),
                FlyFactory.getFly6(),
                FlyFactory.getFly7(),
                FlyFactory.getFly8(),
                FlyFactory.getFly9(),
                FlyFactory.getFly10(),
                FlyFactory.getFly11(),
                FlyFactory.getFly12());

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/flights/lowcost3");

        //Expected --> Status, body y contentype
        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //Body
        ResultMatcher bodyExpected;
        bodyExpected = MockMvcResultMatchers.content().json(
                writer.writeValueAsString(expected)
        );


        System.out.println(writer.writeValueAsString(expected));
        //contentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //Act&assert con mocking
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
}