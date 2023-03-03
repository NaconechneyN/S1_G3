package com.Bootcamp.Spring1.service;

import com.Bootcamp.Spring1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public String bookingHotel () {
        System.out.println("Mostralo");
        return "algo ";
    }

    /* private Double priceHotel () {
        return price;
    } */
}
