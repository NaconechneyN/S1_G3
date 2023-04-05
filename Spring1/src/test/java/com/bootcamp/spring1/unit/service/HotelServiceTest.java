/*package com.bootcamp.spring1.unit.service;

import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.entity.Hotel;
import com.bootcamp.spring1.exceptions.DestinationException;
import com.bootcamp.spring1.repository.HotelRepository;
import com.bootcamp.spring1.repository.IHotelRepository;
import com.bootcamp.spring1.service.classes.HotelService;
import com.bootcamp.spring1.utils.HotelDTOFactory;
import com.bootcamp.spring1.utils.HotelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class HotelServiceTest {
    @Mock
    IHotelRepository hotelRepository;

    @InjectMocks
    HotelService hotelService;

    //@Test
    void hotelByPriceTest(){
        //Arrange
        List<HotelDTO> expected = List.of(HotelDTOFactory.getHotel1());
        List<Hotel> hotel =List.of(HotelFactory.getHotel1());

        //Act & Assert
        Mockito.when(hotelRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual()).thenReturn(hotel);
        var result = hotelService.findByPrice(expected);

        Assertions.assertEquals(expected, result);

    }
}

    /*@Test
    void testFindHotelPrice(){
        // Arrange
        HotelDTO expected = HotelDTOFactory.getHotelDTO1();
        List<Hotel> retorno = List.of(HotelFactory.getHotel1());

        // Act
        Mockito.when(hotelRepository.buscarPrecioHotel(code.getBooking().getHotelCode())).thenReturn(6300.00);
        Mockito.when(hotelRepository.hotelBooking(code.getBooking().getHotelCode())).thenReturn(true);
        Mockito.when(hotelRepository.getHotels()).thenReturn(hotel);
        var result = hotelService.bookingHotel(code);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}

    /*@Test
    void bookingHotelTest() {
        // Arrange
        HotelDTO code = HotelDTOFactory.getHotelDTO1();
        List<HotelModel> hotel = List.of(HotelFactory.getHotel1());
        HotelResponseDTO expected = new HotelResponseDTO("El monto de la reserva es de: ", 63000.00);

        // Act
        Mockito.when(hotelRepository.buscarPrecioHotel(code.getBooking().getHotelCode())).thenReturn(6300.00);
        Mockito.when(hotelRepository.hotelBooking(code.getBooking().getHotelCode())).thenReturn(true);
        Mockito.when(hotelRepository.getHotels()).thenReturn(hotel);
        var result = hotelService.bookingHotel(code);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void notDestinationBookingHotelTest() {
        // Arrange
        HotelDTO code = HotelDTOFactory.getHotelDTO1();
        List<HotelModel> hotel = List.of();

        // Act & Assert
        Mockito.when(hotelRepository.buscarPrecioHotel(code.getBooking().getHotelCode())).thenReturn(6300.00);
        Mockito.when(hotelRepository.hotelBooking(code.getBooking().getHotelCode())).thenReturn(true);
        Mockito.when(hotelRepository.getHotels()).thenReturn(hotel);

        Assertions.assertThrows(DestinationException.class,
                () -> hotelService.bookingHotel(code));
    }
}
*/