package com.bootcamp.spring1.unit.service;

import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.exceptions.DateException;
import com.bootcamp.spring1.exceptions.DestinationException;
import com.bootcamp.spring1.model.HotelModel;
import com.bootcamp.spring1.repository.HotelRepository;
import com.bootcamp.spring1.service.HotelService;
import com.bootcamp.spring1.utils.HotelDTOFactory;
import com.bootcamp.spring1.utils.HotelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {
    @Mock
    HotelRepository hotelRepository;

    @InjectMocks
    HotelService hotelService;

    @Test
    void bookingHotelTest() {
        // Arrange
        HotelRequestDTO codigo = HotelDTOFactory.getHotelDTO1();
        List<HotelModel> hotel = List.of(HotelFactory.getHotel1());
        String expected =
                "El precio de la reserva es de $" + hotel.get(0).getPrice() * 10 + " por " + 10 + " dias de estadía";

        // Act
        Mockito.when(hotelRepository.buscarPrecioHotel(codigo.getBooking().getHotelCode())).thenReturn(6300.00);
        Mockito.when(hotelRepository.hotelBooking(codigo.getBooking().getHotelCode())).thenReturn(true);
        Mockito.when(hotelRepository.getHotels()).thenReturn(hotel);
        var result = hotelService.bookingHotel(codigo);

        // Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    void notDestinationBookingHotelTest() {
        // Arrange
        HotelRequestDTO codigo = HotelDTOFactory.getHotelDTO1();
        List<HotelModel> hotel = List.of();

        // Act & Assert
        Mockito.when(hotelRepository.buscarPrecioHotel(codigo.getBooking().getHotelCode())).thenReturn(6300.00);
        Mockito.when(hotelRepository.hotelBooking(codigo.getBooking().getHotelCode())).thenReturn(true);
        Mockito.when(hotelRepository.getHotels()).thenReturn(hotel);

        Assertions.assertThrows(DestinationException.class,
                ()-> hotelService.bookingHotel(codigo));
    }


}