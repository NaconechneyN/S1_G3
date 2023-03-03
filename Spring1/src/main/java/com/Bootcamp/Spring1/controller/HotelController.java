package com.Bootcamp.Spring1.controller;

import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;
    @GetMapping("/api/v1/hotels")
        public List<HotelModel> listHotel() {
            return hotelService.hotelList();
        }



}
