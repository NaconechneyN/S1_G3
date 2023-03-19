package com.bootcamp.spring1.utils;


import com.bootcamp.spring1.model.FlyModel;

import java.time.LocalDate;


public class FlyFactory {

    public static FlyModel getFly1(){
        return FlyModel.builder()
                .flyNumber("BAPI-1235")
                .origin("Buenos Aires")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .pricePerson(6500)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly2(){
        return FlyModel.builder()
                .flyNumber("PIBA-1420")
                .origin("Puerto Iguazú")
                .destination("Bogotá")
                .seatType("Business")
                .pricePerson(43200)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly3(){
        return FlyModel.builder()
                .flyNumber("PIBA-1420")
                .origin("Puerto Iguazú")
                .destination("Bogotá")
                .seatType("Economy")
                .pricePerson(25735)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly4(){
        return FlyModel.builder()
                .flyNumber("BATU-5536")
                .origin("Buenos Aires")
                .destination("Tucumán")
                .seatType("Economy")
                .pricePerson(7320)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly5(){
        return FlyModel.builder()
                .flyNumber("TUPI-3369")
                .origin("Tucumán")
                .destination("Puerto Iguazú")
                .seatType("Business")
                .pricePerson(12530)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly6(){
        return FlyModel.builder()
                .flyNumber("TUPI-3369")
                .origin("Tucumán")
                .destination("Puerto Iguazú")
                .seatType("Economy")
                .pricePerson(5400)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly7(){
        return FlyModel.builder()
                .flyNumber("BOCA-4213")
                .origin("Bogotá")
                .destination("Cartagena")
                .seatType("Economy")
                .pricePerson(8000)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly8(){
        return FlyModel.builder()
                .flyNumber("CAME-0321")
                .origin("Cartagena")
                .destination("Medellín")
                .seatType("Economy")
                .pricePerson(7800)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly9(){
        return FlyModel.builder()
                .flyNumber("BOBA-6567")
                .origin("Bogotá")
                .destination("Buenos Aires")
                .seatType("Business")
                .pricePerson(57000)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly10(){
        return FlyModel.builder()
                .flyNumber("BOME-4442")
                .origin("Bogotá")
                .destination("Medellín")
                .seatType("Economy")
                .pricePerson(11000)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly11(){
        return FlyModel.builder()
                .flyNumber("BOME-4442")
                .origin("Bogotá")
                .destination("Medellín")
                .seatType("Economy")
                .pricePerson(11000)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
    public static FlyModel getFly12(){
        return FlyModel.builder()
                .flyNumber("MEPI-9986")
                .origin("Medellín")
                .destination("Puerto Iguazú")
                .seatType("Business")
                .pricePerson(41640)
                .departureDate(LocalDate.of(2023,03,10))
                .returnDate(LocalDate.of(2023, 04, 15))
                .build();
    }
}
