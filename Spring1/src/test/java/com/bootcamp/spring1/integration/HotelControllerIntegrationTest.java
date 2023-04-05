package com.bootcamp.spring1.integration;


import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.entity.Hotel;
import com.bootcamp.spring1.utils.HotelDTOFactory;
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
class HotelControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    void listHotelAvailableTest() throws Exception {
        //arrange
        List<Hotel> expected = List.of(HotelFactory.getHotel1());

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/hotels/")
                .queryParam("dateFrom", "10/04/2023")
                .queryParam("dateTo", "20/06/2023")
                .queryParam("destination", "Puerto Iguazú");

        //Expected --> Status, body y contentype
        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
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
    void findRoomTypeTest() throws Exception {

        //arrange
        List<Hotel> expected = List.of(HotelFactory.getHotel10(), HotelFactory.getHotel12());
        String roomType = "Múltiple";
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/hotels/findRoom/{roomType}", roomType);

        //Expected --> Status, body y contentype
        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //Body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
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
