package com.Bootcamp.Spring1.controller;

import com.Bootcamp.Spring1.dto.request.fly.FlyRequestDTO;
import com.Bootcamp.Spring1.dto.request.hotel.HotelRequestDTO;
import com.Bootcamp.Spring1.dto.response.FlyResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlyController {

    @PostMapping("/api/v1/flight-reservation")
    public FlyResponseDTO reservation (@RequestBody FlyRequestDTO flyRequestDTO){
        return null;
                //flyService.reservationFlight(flyRequestDTO);
    }


}
