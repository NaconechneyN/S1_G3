package com.bootcamp.spring1.utils;

import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;


import java.time.LocalDate;

public class HotelDTOFactory {
    public static HotelDTO getHotelDTO1() {
        return HotelDTO.builder()
                .id(10)
                .hotelCode("CP-0004")
                .name("Central Plaza")
                .city("Medellín")
                .roomType("Múltiple")
                .price(8600.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }
    public static HotelDTO getHotelDTO2() {
        return HotelDTO.builder()
                .id(12)
                .hotelCode("BG-0004")
                .name("Bocagrande")
                .city("Cartagena")
                .roomType("Múltiple")
                .price(9370.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }
}
