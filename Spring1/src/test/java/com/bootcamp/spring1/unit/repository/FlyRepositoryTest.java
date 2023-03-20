package com.bootcamp.spring1.unit.repository;

import com.bootcamp.spring1.exceptions.NullException;
import com.bootcamp.spring1.model.FlyModel;
import com.bootcamp.spring1.repository.FlyRepository;
import com.bootcamp.spring1.repository.HotelRepository;
import com.bootcamp.spring1.utils.FlyFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FlyRepositoryTest {
    FlyRepository flyRepository;

    @BeforeEach
    void setup() {
        flyRepository = new FlyRepository();
    }

    @Test
    void getFlightsTest() {
        //arrange
        List<FlyModel> expected = new ArrayList<>();
        FlyModel flights1 = FlyFactory.getFly1();
        FlyModel flights2 = FlyFactory.getFly2();
        FlyModel flights3 = FlyFactory.getFly3();
        FlyModel flights4 = FlyFactory.getFly4();
        FlyModel flights5 = FlyFactory.getFly5();
        FlyModel flights6 = FlyFactory.getFly6();
        FlyModel flights7 = FlyFactory.getFly7();
        FlyModel flights8 = FlyFactory.getFly8();
        FlyModel flights9 = FlyFactory.getFly9();
        FlyModel flights10 = FlyFactory.getFly10();
        FlyModel flights11 = FlyFactory.getFly11();
        FlyModel flights12 = FlyFactory.getFly12();

        expected.add(flights1);
        expected.add(flights2);
        expected.add(flights3);
        expected.add(flights4);
        expected.add(flights5);
        expected.add(flights6);
        expected.add(flights7);
        expected.add(flights8);
        expected.add(flights9);
        expected.add(flights10);
        expected.add(flights11);
        expected.add(flights12);

        //act
        var result = flyRepository.getFlights();

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getNotExistFlightsTest() {
        //arrange
        flyRepository.flights = new ArrayList<>();

        //act y assert
        Assertions.assertThrows(NullException.class,
                () -> flyRepository.getFlights());
    }

    @Test
    void availableListFlyTest() {
        //arrange
        List<FlyModel> expected = new ArrayList<>();
        String origin = "Bogotá";
        String destination = "Cartagena";
        LocalDate departureDate = LocalDate.of(2023, 03, 10);
        LocalDate returnDate = LocalDate.of(2023, 04, 15);
        FlyModel flights = FlyFactory.getFly7();
        expected.add(flights);

        //act
        var result = flyRepository.availableListFly(origin, destination, departureDate, returnDate);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void availableListIsEmptyFlightsTest() {
        //arrange
        String origin = "Sunchales";
        String destination = "Gral. Pico";
        LocalDate departureDate = LocalDate.of(2022, 03, 10);
        LocalDate returnDate = LocalDate.of(2022, 04, 15);

        //act y assert
        Assertions.assertThrows(NullException.class,
                () -> flyRepository.availableListFly(origin, destination, departureDate, returnDate));
    }
}