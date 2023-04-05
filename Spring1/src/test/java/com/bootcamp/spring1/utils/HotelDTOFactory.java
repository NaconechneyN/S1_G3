package com.bootcamp.spring1.utils;

import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;


import java.time.LocalDate;

public class HotelDTOFactory {
    public static BookingDTO getHotelDTO1() {
        return BookingDTO.builder()
                                .hotelCode("CH-0002")
                                .dateFrom(LocalDate.of(2023, 04, 10))
                                .dateTo(LocalDate.of(2023, 06, 20))
                                .roomType("doble")
                                .peopleAmount(2)
                                .city("Puerto Iguazú")
                                .build();
    }

    public static BookingDTO getHotelDTO2() {
        return BookingDTO.builder()
                .hotelCode("CH-0003")
                .dateFrom(LocalDate.of(2023, 04, 10))
                .dateTo(LocalDate.of(2023, 05, 23))
                .roomType("triple")
                .peopleAmount(3)
                .city("Puerto Iguazú")
                .build();
    }
}
