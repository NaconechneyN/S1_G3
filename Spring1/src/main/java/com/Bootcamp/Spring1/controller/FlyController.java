package com.Bootcamp.Spring1.controller;

import com.Bootcamp.Spring1.model.FlyModel;
import com.Bootcamp.Spring1.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Bootcamp.Spring1.dto.request.fly.FlyRequestDTO;
import com.Bootcamp.Spring1.dto.request.hotel.HotelRequestDTO;
import com.Bootcamp.Spring1.dto.response.FlyResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class FlyController {
    @Autowired
    FlyService flyService;

    // Aca se agregan los parametros
    @GetMapping("/api/v1/flights")
    public List<FlyModel> listFlyAvailable() {
        return flyService.flightsList();
    }

    @PostMapping("/api/v1/flight-reservation")
    public FlyResponseDTO reservation (@RequestBody FlyRequestDTO flyRequestDTO){
        return flyService.reservationFlight(flyRequestDTO);
    }


}
