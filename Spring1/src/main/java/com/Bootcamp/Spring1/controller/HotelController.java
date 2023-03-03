package com.Bootcamp.Spring1.controller;

import com.Bootcamp.Spring1.dto.request.HotelRequestDTO;
import com.Bootcamp.Spring1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/api/v1/hotels")
    public HotelRequestDTO booking(@RequestBody HotelRequestDTO datosReserva){
        return hotelService.bookingHotel(datosReserva);
    }
}
