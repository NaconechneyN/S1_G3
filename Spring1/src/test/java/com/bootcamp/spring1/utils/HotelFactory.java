package com.bootcamp.spring1.utils;


import com.bootcamp.spring1.entity.Hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelFactory {
    //Factory Hotels
    public static Hotel getHotel1() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
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

    public static Hotel getHotel2() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
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

    public static Hotel getHotel3() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(3)
                .hotelCode("HB-0001")
                .name("Hotel Bristol")
                .city("Buenos Aires")
                .roomType("single")
                .price(5435.00)
                .dateFrom(LocalDate.of(2023, 02, 10))
                .dateTo(LocalDate.of(2023, 06, 19))
                .booked(false)
                .build();
    }

    public static Hotel getHotel4() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(4)
                .hotelCode("BH-0002")
                .name("Hotel Bristol 2")
                .city("Buenos Aires")
                .roomType("doble")
                .price(7200.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }

    public static Hotel getHotel5() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(5)
                .hotelCode("SH-0002")
                .name("Sheraton")
                .city("Tucumán")
                .roomType("doble")
                .price(5790.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }

    public static Hotel getHotel6() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(6)
                .hotelCode("SH-0001")
                .name("Sheraton 2")
                .city("Tucumán")
                .roomType("single")
                .price(4150.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }

    public static Hotel getHotel7() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(7)
                .hotelCode("SE-0001")
                .name("Selina")
                .city("Bogotá")
                .roomType("single")
                .price(3900.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }

    public static Hotel getHotel8() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(8)
                .hotelCode("SE-0002")
                .name("Selina 2")
                .city("Bogotá")
                .roomType("doble")
                .price(5840.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }

    public static Hotel getHotel9() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(9)
                .hotelCode("EC-0003")
                .name("El Campín")
                .city("Bogotá")
                .roomType("triple")
                .price(7020.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }

    public static Hotel getHotel10() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
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

    public static Hotel getHotel11() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
                .id(11)
                .hotelCode("CP-0002")
                .name("Central Plaza 2")
                .city("Medellín")
                .roomType("doble")
                .price(6400.00)
                .dateFrom(LocalDate.of(2023, 02, 12))
                .dateTo(LocalDate.of(2023, 06, 17))
                .booked(false)
                .build();
    }

    public static Hotel getHotel12() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Hotel.builder()
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
