package com.bootcamp.spring1.controller;

import com.bootcamp.spring1.model.FlyModel;
import com.bootcamp.spring1.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.response.FlyResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@Validated
public class FlyController {
    @Autowired
    FlyService flyService;

    // Aca se agregan los parametros

    //Validaciones --> comparar las fechas en el controler entrada<salida, si hay error se lanza excepción.
    //              -->corregir formato de fechas a / en vez de guiones.

    @GetMapping("/api/v1/flights")
    public List<FlyModel> listFlyAvailable(@NotEmpty @RequestParam(required = false) String dateTo,
                                           @NotEmpty @RequestParam(required = false) String dateFrom,
                                           @NotEmpty @RequestParam(required = false) String origin,
                                           @NotEmpty @RequestParam(required = false) String destination) {
        return flyService.availableListFly(dateTo, dateFrom, origin, destination);
    }

    @PostMapping("/api/v1/flight-reservation")
    public FlyResponseDTO reservation(@Valid @RequestBody FlyRequestDTO flyRequestDTO) {
        return flyService.reservationFlight(flyRequestDTO);
    }

}
