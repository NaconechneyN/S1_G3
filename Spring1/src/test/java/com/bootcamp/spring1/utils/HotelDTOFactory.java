package com.bootcamp.spring1.utils;

import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;


import java.time.LocalDate;

public class HotelDTOFactory {
    public static HotelDTO getHotelDTO1() {
        return HotelDTO.builder()
                .id(1)
                .hotelCode("CH-0002")
                .name("Cataratas Hotel")
                .city("Puerto Iguazú")
                .roomType("doble")
                .price(6300.00)
                .dateFrom(LocalDate.of(2023, 04, 10))
                .dateTo(LocalDate.of(2023, 06, 20))
                .booked(false)
                .build();
    }

    public static HotelDTO getHotelDTO2() {
        return HotelDTO.builder()
                .id(2)
                .hotelCode("CH-0003")
                .name("Cataratas Hotel 2")
                .city("Puerto Iguazú")
                .roomType("triple")
                .price(8300.00)
                .dateFrom(LocalDate.of(2023, 04, 10))
                .dateTo(LocalDate.of(2023, 05, 23))
                .booked(false)
                .build();
    }
}
