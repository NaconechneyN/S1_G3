package com.bootcamp.spring1.repository;

import com.bootcamp.spring1.dto.FlyDTO;
import com.bootcamp.spring1.entity.BookingFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingFlightRepository extends JpaRepository<BookingFlight, Integer> {


}
