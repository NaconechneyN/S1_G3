package com.bootcamp.spring1.unit.service;

import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.response.FlyResponseDTO;
import com.bootcamp.spring1.exceptions.DestinationException;
import com.bootcamp.spring1.model.FlyModel;
import com.bootcamp.spring1.repository.FlyRepository;
import com.bootcamp.spring1.service.FlyService;
import com.bootcamp.spring1.utils.FlyDTOFactory;
import com.bootcamp.spring1.utils.FlyFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FlyServiceTest {

    @Mock
    FlyRepository flyRepository;
    @InjectMocks
    FlyService flyService;

    @Test
    void reservationFlightTest() {
        // Arrange
        List<FlyModel> flights = List.of(FlyFactory.getFly1());
        FlyResponseDTO expected = new FlyResponseDTO("El monto total del vuelo es de: ", flights.get(0).getPricePerson());
        FlyRequestDTO asientos = FlyDTOFactory.getFly1();

        // Act
        Mockito.when(flyRepository.searchFlightPrice(asientos.getFlightReservation().getFlightNumber())).thenReturn(6500);
        Mockito.when(flyRepository.getFlights()).thenReturn(flights);
        var result = flyService.reservationFlight(asientos);

        // Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    void notReservationFlightTest (){
        // Arrange
        FlyRequestDTO asientos = FlyDTOFactory.getFly1();
        List<FlyModel> flights = List.of();

        // Act & Assert
        Mockito.when(flyRepository.searchFlightPrice(asientos.getFlightReservation().getFlightNumber())).thenReturn(6500);
        Mockito.when(flyRepository.getFlights()).thenReturn(flights);
        Assertions.assertThrows(DestinationException.class,
                ()-> flyService.reservationFlight(asientos));

    }
}

