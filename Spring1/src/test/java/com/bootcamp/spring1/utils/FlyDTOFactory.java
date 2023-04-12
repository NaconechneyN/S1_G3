package com.bootcamp.spring1.utils;


import com.bootcamp.spring1.dto.FlyDTO;
import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class FlyDTOFactory {
    public static FlyDTO getFly1() {
        return FlyDTO.builder()
                                .flightNumber("BAPI-1235")
                                .origin("Buenos Aires")
                                .destination("Puerto Iguazú")
                                .seatType("Economy")//verificar la escritura
                                .flightPrice(6500)//verificar precio
                                .dateFrom(LocalDate.of(2023, 03, 10))
                                .dateTo(LocalDate.of(2023, 04, 15))
                                .build();
    }
}

