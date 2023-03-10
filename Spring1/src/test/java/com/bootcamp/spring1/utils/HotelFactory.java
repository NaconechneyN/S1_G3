package com.bootcamp.spring1.utils;


import com.bootcamp.spring1.model.HotelModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelFactory {
    public static HotelModel getHotels() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return HotelModel.builder()
                .codeHotel("CH-0002")
                .name("Cataratas Hotel")
                .city("Puerto Iguazú")
                .roomTipe("doble")
                .price(6300.00)
                .availableFromDate(LocalDate.of(2022,02,10))
                .availableUntilDate(LocalDate.of(2022,03,20))
                .reserved(false)
                .build();
    }

}
