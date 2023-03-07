package com.Bootcamp.Spring1.controller;

import com.Bootcamp.Spring1.dto.request.HotelRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlyController {

    @PostMapping("/api/v1/flight-reservation")
    public String reservation (@RequestBody HotelRequestDTO datosReserva){
        return null;
                //flyService.bookingHotel(datosReserva);
    }


}
