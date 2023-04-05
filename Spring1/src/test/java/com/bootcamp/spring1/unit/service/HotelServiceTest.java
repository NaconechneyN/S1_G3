package com.bootcamp.spring1.unit.service;
import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.entity.Hotel;
import com.bootcamp.spring1.exceptions.NullException;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HotelServiceTest {
    @Mock
    IHotelRepository hotelRepository;

    @InjectMocks
    HotelService hotelService;


    @Test
    void testFindByCityAndName() {
        // Arrange
        List<HotelDTO> expected = List.of(HotelDTOFactory.getHotelDTO2());
        List<Hotel> retorno = List.of(HotelFactory.getHotel2());


        // Act
        Mockito.when(hotelRepository.findByCityAndNameContainingAndBookedFalse("Puerto Iguazú", "Cataratas Hotel 2")).thenReturn(retorno);
        var result = hotelService.findByCityAndName("Puerto Iguazú", "Cataratas Hotel 2");

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testFindByCityAndNameEmpty(){
        //Arrange

        List<Hotel> hotel =List.of();

        // Act & Assert
        Mockito.when(hotelRepository.findByCityAndNameContainingAndBookedFalse("Rosario", "Balacera")).thenReturn(hotel);

        Assertions.assertThrows(NullException.class,
                () -> hotelService.findByCityAndName("Rosario", "Balacera"));

    }


    /*
    @Test
    void bookingHotelTest() {
        // Arrange
        BookingDTO code = HotelDTOFactory.getHotelDTO1();
        List<Hotel> hotel = List.of(HotelFactory.getHotel1());
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
*/
}