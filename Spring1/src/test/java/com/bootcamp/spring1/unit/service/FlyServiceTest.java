package com.bootcamp.spring1.unit.service;

import com.bootcamp.spring1.dto.FlyDTO;
import com.bootcamp.spring1.entity.Flight;
import com.bootcamp.spring1.repository.IFlyRepository;
import com.bootcamp.spring1.service.classes.FlyService;
import com.bootcamp.spring1.utils.FlyDTOFactory;
import com.bootcamp.spring1.utils.FlyFactory;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class FlyServiceTest {

    @Mock
    IFlyRepository flyRepository;
    @InjectMocks
    FlyService flyService;

    @Test
    void findByOrderByFlightPriceDesc() {
        //Arrange
        List<Flight> flights = List.of(FlyFactory.getFly1());
        List<FlyDTO> expected = List.of(FlyDTOFactory.getFly1());
        //Act
        Mockito.when(flyRepository.findByOrderByFlightPriceDesc()).thenReturn(flights);
        var result = flyService.findByOrderByFlightPriceDesc();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findByOrderByFlightPriceAsc() {
        //Arrange
            List<Flight> flights = List.of(FlyFactory.getFly1());
            List<FlyDTO> expected = List.of(FlyDTOFactory.getFly1());
        //Act
            Mockito.when(flyRepository.findByOrderByFlightPriceAsc()).thenReturn(flights);
            var result = flyService.findByOrderByFlightPriceAsc();
        //Assert
            Assertions.assertEquals(expected, result);
    }

    @Test
    void findByPrice() {
        //Arrange
//        List<Flight> flights = List.of(FlyFactory.getFly1());
//        List<FlyDTO> expected = List.of(FlyDTOFactory.getFly1());
        //Act
//        Mockito.when(flyRepository.findByPrice(Integer minPrice, Integer maxPrice)).thenReturn(flights);
//        var result = flyService.findByPrice(6500,4000);
        //Assert
//        Assertions.assertEquals(expected, result);
    }

    @Test
    void findBySeatTypeEquals() {
        //Arrange
        //Act
        //Assert
    }

//    @Test
//    void reservationFlightTest() {
//        // Arrange
//        List<FlyModel> flights = List.of(FlyFactory.getFly1());
//        FlyResponseDTO expected = new FlyResponseDTO("El monto total del vuelo es de: ", flights.get(0).getPricePerson());
//        FlyRequestDTO asientos = FlyDTOFactory.getFly1();
//
//        // Act
//        Mockito.when(flyRepository.searchFlightPrice(asientos.getFlightReservation().getFlightNumber())).thenReturn(6500);
//        Mockito.when(flyRepository.getFlights()).thenReturn(flights);
//        var result = flyService.reservationFlight(asientos);
//
//        // Assert
//        Assertions.assertEquals(expected, result);
//    }
//
//    @Test
//    void notReservationFlightTest() {
//        // Arrange
//        FlyRequestDTO asientos = FlyDTOFactory.getFly1();
//        List<FlyModel> flights = List.of();
//
//        // Act & Assert
//        Mockito.when(flyRepository.searchFlightPrice(asientos.getFlightReservation().getFlightNumber())).thenReturn(6500);
//        Mockito.when(flyRepository.getFlights()).thenReturn(flights);
//        Assertions.assertThrows(DestinationException.class,
//                () -> flyService.reservationFlight(asientos));
//    }
}

