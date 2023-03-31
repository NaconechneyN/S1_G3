/*package com.bootcamp.spring1.unit.repository;

import com.bootcamp.spring1.exceptions.NullException;
import com.bootcamp.spring1.repository.HotelRepository;
import com.bootcamp.spring1.utils.HotelFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class HotelRepositoryTest {
    HotelRepository hotelRepository;

    @BeforeEach
    void setup() {
        hotelRepository = new HotelRepository();
    }

    @Test
    void getHotelsTest() {
        //arrange
        List<HotelModel> expected = new ArrayList<>();
        HotelModel hotels1 = HotelFactory.getHotel1();
        HotelModel hotels2 = HotelFactory.getHotel2();
        HotelModel hotels3 = HotelFactory.getHotel3();
        HotelModel hotels4 = HotelFactory.getHotel4();
        HotelModel hotels5 = HotelFactory.getHotel5();
        HotelModel hotels6 = HotelFactory.getHotel6();
        HotelModel hotels7 = HotelFactory.getHotel7();
        HotelModel hotels8 = HotelFactory.getHotel8();
        HotelModel hotels9 = HotelFactory.getHotel9();
        HotelModel hotels10 = HotelFactory.getHotel10();
        HotelModel hotels11 = HotelFactory.getHotel11();
        HotelModel hotels12 = HotelFactory.getHotel12();

        expected.add(hotels1);
        expected.add(hotels2);
        expected.add(hotels3);
        expected.add(hotels4);
        expected.add(hotels5);
        expected.add(hotels6);
        expected.add(hotels7);
        expected.add(hotels8);
        expected.add(hotels9);
        expected.add(hotels10);
        expected.add(hotels11);
        expected.add(hotels12);

        //act
        var result = hotelRepository.getHotels();

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void hotelWithNoExistentTest() {
        //arrange
        hotelRepository.hotels = new ArrayList<>();

        //act & assert
        Assertions.assertThrows(NullException.class,
                () -> hotelRepository.getHotels()); //estructura general para ejecutar el método con excepción
    }

    @Test
    void getHotelsQuantityTest() {
        //arrange
        Integer expected = 12;

        //act
        var result = hotelRepository.getHotels();

        //assert
        Assertions.assertEquals(expected, result.size());
    }

    @Test
    void availableListHotelsTest() {
        //arrange
        List<HotelModel> expected = new ArrayList<>();
        String city = ("Puerto Iguazú");
        LocalDate availableFromDate = LocalDate.of(2023, 04, 10);
        LocalDate availableUntilDate = LocalDate.of(2023, 06, 20);
        HotelModel hotels = HotelFactory.getHotel1();
        expected.add(hotels);

        //act
        var result = hotelRepository.availableListHotels(city, availableFromDate, availableUntilDate);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void availableListEmptyHotelsTest() {
        //arrange
        String city = ("Rafaela");
        LocalDate availableFromDate = LocalDate.of(2022, 04, 10);
        LocalDate availableUntilDate = LocalDate.of(2022, 06, 20);
        //act & assert
        Assertions.assertThrows(NullException.class,
                () -> hotelRepository.availableListHotels(city, availableFromDate, availableUntilDate));
    }

    @Test
    void buscarPrecioHotelTest() {
        //arrange
        String codeHotel = "CH-0002";
        Double expected = HotelFactory.getHotel1().getPrice();

        //act
        var result = hotelRepository.buscarPrecioHotel(codeHotel);

        //assert
        Assertions.assertEquals(expected, result);
    }
}
*/