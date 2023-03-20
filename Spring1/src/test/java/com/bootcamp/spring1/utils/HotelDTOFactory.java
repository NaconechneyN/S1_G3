package com.bootcamp.spring1.utils;

import com.bootcamp.spring1.dto.request.HostDTO;
import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.model.HotelModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelDTOFactory {

    public static HotelRequestDTO getHotelDTO1 (){
        return HotelRequestDTO.builder()
                .username("Cerdito Pateador")
                .booking(
                BookingDTO.builder()
                        .hotelCode("CH-0002")
                        .dateFrom(LocalDate.of(2023,04,10))
                        .dateTo(LocalDate.of(2023,06,20))
                        .roomType("doble")
                        .peopleAmount(2)
                        .destination("Puerto Iguazú")
                        .build()
                )
                .build();
    }

}
