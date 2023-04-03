package com.bootcamp.spring1.repository;

import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.entity.BookingHotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingHotelRepository extends JpaRepository <BookingHotel, Integer> {



}
