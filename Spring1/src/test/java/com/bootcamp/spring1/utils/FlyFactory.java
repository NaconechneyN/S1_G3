package com.bootcamp.spring1.utils;


import com.bootcamp.spring1.entity.Flight;

import java.time.LocalDate;


public class FlyFactory {

    public static Flight getFly1() {
        return Flight.builder()
                .id(1)
                .flightNumber("BAPI-1235")
                .origin("Buenos Aires")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .flightPrice(6500)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly2() {
        return Flight.builder()
                .id(2)
                .flightNumber("PIBA-1420")
                .origin("Puerto Iguazú")
                .destination("Bogotá")
                .seatType("Business")
                .flightPrice(43200)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly3() {
        return Flight.builder()
                .id(3)
                .flightNumber("PIBA-1420")
                .origin("Buenos Aires")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .flightPrice(25735)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly4() {
        return Flight.builder()
                .id(4)
                .flightNumber("BATU-5536")
                .origin("Buenos Aires")
                .destination("Tucumán")
                .seatType("Economy")
                .flightPrice(7320)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly5() {
        return Flight.builder()
                .id(5)
                .flightNumber("TUPI-3369")
                .origin("Tucumán")
                .destination("Puerto Iguazú")
                .seatType("Business")
                .flightPrice(12530)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly6() {
        return Flight.builder()
                .id(6)
                .flightNumber("TUPI-3369")
                .origin("Tucumán")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .flightPrice(5400)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly7() {
        return Flight.builder()
                .id(7)
                .flightNumber("BOCA-4213")
                .origin("Bogotá")
                .destination("Cartagena")
                .seatType("Economy")
                .flightPrice(8000)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly8() {
        return Flight.builder()
                .id(8)
                .flightNumber("CAME-0321")
                .origin("Cartagena")
                .destination("Medellín")
                .seatType("Economy")
                .flightPrice(7800)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly9() {
        return Flight.builder()
                .id(9)
                .flightNumber("BOBA-6567")
                .origin("Bogotá")
                .destination("Buenos Aires")
                .seatType("Business")
                .flightPrice(57000)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly10() {
        return Flight.builder()
                .id(10)
                .flightNumber("BOBA-6567")
                .origin("Bogotá")
                .destination("Buenos Aires")
                .seatType("Economy")
                .flightPrice(39860)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly11() {
        return Flight.builder()
                .id(11)
                .flightNumber("BOME-4442")
                .origin("Bogotá")
                .destination("Medellín")
                .seatType("Economy")
                .flightPrice(11000)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }

    public static Flight getFly12() {
        return Flight.builder()
                .id(12)
                .flightNumber("MEPI-9986")
                .origin("Medellín")
                .destination("Puerto Iguazú")
                .seatType("Business")
                .flightPrice(41640)
                .dateFrom(LocalDate.of(2023, 03, 10))
                .dateTo(LocalDate.of(2023, 04, 15))
                .reservation(false)
                .build();
    }
}
