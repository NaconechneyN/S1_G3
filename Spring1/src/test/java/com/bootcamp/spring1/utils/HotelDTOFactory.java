package com.bootcamp.spring1.utils;

import com.bootcamp.spring1.model.HotelModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelDTOFactory {

    public static HotelModel getHotel1DTO() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("CH-0002")
                .name("Cataratas Hotel")
                .city("Puerto Iguazú")
                .roomTipe("doble")
                .price(6300.00)
                .availableFromDate(LocalDate.of(2023,04,10))
                .availableUntilDate(LocalDate.of(2023,06,20))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel2() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("CH-0003")
                .name("Cataratas Hotel 2")
                .city("Puerto Iguazú")
                .roomTipe("triple")
                .price(8300.00)
                .availableFromDate(LocalDate.of(2023,04,10))
                .availableUntilDate(LocalDate.of(2023,05,23))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel3() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("HB-0001")
                .name("Hotel Bristol")
                .city("Buenos Aires")
                .roomTipe("single")
                .price(5435.00)
                .availableFromDate(LocalDate.of(2023,02,10))
                .availableUntilDate(LocalDate.of(2023,06,19))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel4() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("BH-0002")
                .name("Hotel Bristol 2")
                .city("Buenos Aires")
                .roomTipe("doble")
                .price(7200.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel5() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("SH-0002")
                .name("Sheraton")
                .city("Tucumán")
                .roomTipe("doble")
                .price(5790.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel6() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("SH-0001")
                .name("Sheraton 2")
                .city("Tucumán")
                .roomTipe("single")
                .price(4150.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel7() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("SE-0001")
                .name("Selina")
                .city("Bogotá")
                .roomTipe("single")
                .price(3900.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel8() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("SE-0002")
                .name("Selina 2")
                .city("Bogotá")
                .roomTipe("doble")
                .price(5840.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel9() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("EC-0003")
                .name("El Campín")
                .city("Bogotá")
                .roomTipe("triple")
                .price(7020.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel10() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("CP-0004")
                .name("Central Plaza")
                .city("Medellín")
                .roomTipe("Múltiple")
                .price(8600.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel11() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("CP-0002")
                .name("Central Plaza 2")
                .city("Medellín")
                .roomTipe("doble")
                .price(6400.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
    public static HotelModel getHotel12() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return HotelModel.builder()
                .codeHotel("BG-0004")
                .name("Bocagrande")
                .city("Cartagena")
                .roomTipe("Múltiple")
                .price(9370.00)
                .availableFromDate(LocalDate.of(2023,02,12))
                .availableUntilDate(LocalDate.of(2023,06,17))
                .reserved(false)
                .build();
    }
}
