package com.bootcamp.spring1.repository;

import com.bootcamp.spring1.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IFlyRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByDateFromLessThanEqualAndDateToGreaterThanEqualAndOriginEqualsAndDestinationEquals(LocalDate dateFrom,
                                                                                  LocalDate dateTo,
                                                                                  String origin,
                                                                                  String destination);



    Flight findByFlightNumber(String code);

    //interface para requerimiento 1 de Aye.
//    List <Flight> findByFlightPriceOrderByFlightPriceDesc ();
    List <Flight>findByOrderByFlightPriceDesc();

    //interface para requerimiento 2 de Aye.
    List <Flight>findByOrderByFlightPriceAsc();

    //interface para requerimiento 3 de Aye.
    List <Flight> findByFlightPriceGreaterThanEqualAndFlightPriceLessThanEqual (Integer minPrice, Integer maxPrice);

    //interface para requerimiento 4 de Aye.

    List <Flight> findBySeatTypeEquals(String type);

}
