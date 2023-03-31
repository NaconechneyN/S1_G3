/*package com.bootcamp.spring1.utils;

import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelDTO;

import java.time.LocalDate;

public class HotelDTOFactory {
    public static HotelDTO getHotelDTO1() {
        return HotelDTO.builder()
                .username("Cerdito Pateador")
                .booking(
                        BookingDTO.builder()
                                .hotelCode("CH-0002")
                                .dateFrom(LocalDate.of(2023, 04, 10))
                                .dateTo(LocalDate.of(2023, 06, 20))
                                .roomType("doble")
                                .peopleAmount(2)
                                .destination("Puerto Iguazú")
                                .build()
                )
                .build();
    }
}
*/