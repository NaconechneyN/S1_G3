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
import javax.validation.constraints.Positive;
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

    // EP para crear un nuevo vuelo
    @PostMapping("/new")
    public ResponseEntity<FlyDTO> create(@RequestBody FlyDTO flyDTO) {
        return ResponseEntity.ok(
                flyService.saveEntity(flyDTO)
        );
    }

    // EP para dar de alta una reserva de vuelo
    @PostMapping("/reservation/new")
    public FlyResponseDTO booking(@RequestBody FlyRequestDTO flyRequestDTO) {
        return flyService.flightBooking(flyRequestDTO);
    }

    // EP para Editar Flights
    @PutMapping ("/edit/{code}")
    public ResponseEntity<FlyDTO> putHotel(@RequestBody FlyDTO flyDTO) {
        return ResponseEntity.ok(
                flyService.saveEntity(flyDTO)
        );
    }

    // EP para modificar una reserva de un vuelo
    @PutMapping ("/reserve/edit/{code}")
    public ResponseEntity<FlyResponseDTO> putBooking(@RequestBody FlyRequestDTO flyRequestDTO) {
        return ResponseEntity.ok(
                flyService.flightBooking(flyRequestDTO)
        );
    }

    // EP para ver todos los vuelos
    @GetMapping("/all")
    public ResponseEntity<List<FlyDTO>> flightsList() {
        return ResponseEntity.ok(
                flyService.getAllEntities()
        );
    }

    // EP para ver todos los vuelos por parámetros
    @GetMapping("/")
    public ResponseEntity<List<FlyDTO>> availableListHotels(
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination) {
        return ResponseEntity.ok(
                flyService.findByParameter(dateFrom, dateTo, origin, destination)
        );
    }

    // Falta para ver todas las reservas

    // EP eliminar un vuelo
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<ValidationDTO> deleteEntity(@PathVariable String code) {
        return ResponseEntity.ok(
                flyService.deleteEntity(code)
        );
    }

    // Falta eliminar una reserva de vuelo


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
