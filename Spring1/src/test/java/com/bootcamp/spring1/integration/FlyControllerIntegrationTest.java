/*package com.bootcamp.spring1.integration;

import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.response.FlyResponseDTO;
import com.bootcamp.spring1.utils.FlyDTOFactory;
import com.bootcamp.spring1.utils.FlyFactory;
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
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    void listFlyAvailableTest() throws Exception {
        List<FlyModel> expected = List.of(FlyFactory.getFly1());

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/flights")
                .queryParam("dateFrom", "10/03/2023")
                .queryParam("dateTo", "15/04/2023")
                .queryParam("origin", "Buenos Aires")
                .queryParam("destination", "Puerto Iguazú");

        //Expected
        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //body
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                writer.writeValueAsString(expected));

        //contentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(
                MediaType.APPLICATION_JSON);

        //act & assert con mocking
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }

    @Test
    void reservationTest() throws Exception {
        //request
        FlyRequestDTO bodyRequest = FlyDTOFactory.getFly1();
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post("/api/v1/flight-reservation")
                        .content(writer.writeValueAsString(bodyRequest))
                        .contentType(MediaType.APPLICATION_JSON);
        //Expected
        //Status
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        //body
        var expectedResponse = new FlyResponseDTO("El monto total del vuelo es de: ", 6500);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse));

        //contentType
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //act & assert con mocking
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(statusExpected, bodyExpected, contentTypeExpected);
    }
}
*/