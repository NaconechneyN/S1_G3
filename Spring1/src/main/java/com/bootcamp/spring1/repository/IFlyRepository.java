package com.bootcamp.spring1.repository;

import com.bootcamp.spring1.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IFlyRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByDateFromLessThanEqualAndDateToGreaterThanEqualAndOriginEquals(LocalDate dateFrom,
                                                                                  LocalDate dateTo,
                                                                                  String destination);



    Flight findByFlightNumber(String code);

}