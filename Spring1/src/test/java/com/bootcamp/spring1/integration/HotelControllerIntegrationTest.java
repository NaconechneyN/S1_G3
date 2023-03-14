package com.bootcamp.spring1.integration;

import com.bootcamp.spring1.model.HotelModel;
import com.bootcamp.spring1.utils.HotelFactory;
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
public class HotelControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;


    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .registerModule(new JavaTimeModule())
            .writer();

    @Test

    public void listHotelAvailableTest() throws Exception {
        //arrange
        List<HotelModel> expected = List.of(HotelFactory.getHotels());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/hotels")
                .queryParam("dateFrom","10-02-2022")
                .queryParam("dateTo","20-03-2022")
                .queryParam("destination","Puerto Iguazú");

        //Request
        //Expected --> Status, body y contentype
        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                writer.writeValueAsString(expected)
        );

        System.out.println(writer.writeValueAsString(expected));
        //contetype
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //Act&assert con mocking
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected,bodyExpected,contentTypeExpected);
    }

    @Test
    public void bookingTest() {
        //arrange
        //Request
        //Expected --> Status, body y contentype
        //Act&assert con mocking
    }

    @Test
    public void precioTest() {
        //arrange
        //Request
        //Expected --> Status, body y contentype
        //Act&assert con mocking
    }
}
