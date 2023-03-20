package com.bootcamp.spring1.utils;

import com.bootcamp.spring1.dto.request.fly.FlightReservationRequestDTO;
import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.model.FlyModel;

import java.time.LocalDate;

public class FlyDTOFactory {
    public static FlyRequestDTO getFly1() {
        return FlyRequestDTO.builder()
                .userName("Chanchito feliz")
                .flightReservation(
                        FlightReservationRequestDTO.builder()
                                .flightNumber("BAPI-1235")
                                .seats(1)
                                .dateFrom(LocalDate.of(2023, 03, 10))
                                .dateTo(LocalDate.of(2023, 04, 15))
                                .origin("Buenos Aires")
                                .destination("Puerto Iguazú")
                                .build()
                )
                .build();
    }
}

