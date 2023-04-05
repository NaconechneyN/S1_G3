package com.bootcamp.spring1.repository;

import com.bootcamp.spring1.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
    //El repository devuelve solo entidades
    List<Hotel> findByDateFromLessThanEqualAndDateToGreaterThanEqualAndCityEquals(LocalDate dateFrom,
                                                                                  LocalDate dateTo,
                                                                                  String destination);

    Hotel findByHotelCode(String code);

    // Interface para EP Francisco
    List <Hotel> findByPriceGreaterThanEqualAndPriceLessThanEqual (Double minPrice, Double maxPrice);
}
