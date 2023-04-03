package com.bootcamp.spring1.controller;

import com.bootcamp.spring1.dto.FlyDTO;
import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.service.classes.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.response.FlyResponseDTO;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping("api/v1/flights")
public class FlyController {
    @Autowired
    FlyService flyService;

    // Aca se agregan los parametros

    //Validaciones --> comparar las fechas en el controler entrada<salida, si hay error se lanza excepción.
    //              -->corregir formato de fechas a / en vez de guiones.

    @PostMapping("/new/")
    public ResponseEntity<FlyDTO> create(@RequestBody FlyDTO flyDTO) {
        return ResponseEntity.ok(
                flyService.saveEntity(flyDTO)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlyDTO>> flightsList() {
        return ResponseEntity.ok(
                flyService.getAllEntities()
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<FlyDTO>> availableListHotels(
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam(required = false) String destination) {
        return ResponseEntity.ok(
                flyService.findByParameter(dateFrom, dateTo, destination)
        );
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<ValidationDTO> deleteEntity(@PathVariable String code) {
        return ResponseEntity.ok(
                flyService.deleteEntity(code)
        );
    }


    /*
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
    }*/

}
