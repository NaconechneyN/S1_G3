package com.Bootcamp.Spring1.controller;

import com.Bootcamp.Spring1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/api/v1/hotels")
    public String booking(){
        return hotelService.bookingHotel();
    }
}
