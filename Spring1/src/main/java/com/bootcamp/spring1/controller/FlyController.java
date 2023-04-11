package com.bootcamp.spring1.controller;

import com.bootcamp.spring1.dto.FlyDTO;
import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.service.classes.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.response.FlyResponseDTO;
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
    @PutMapping("/edit/{code}")
    public ResponseEntity<FlyDTO> putHotel(@RequestBody FlyDTO flyDTO) {
        return ResponseEntity.ok(
                flyService.saveEntity(flyDTO)
        );
    }

    // EP para modificar una reserva de un vuelo - Da errores
    @PutMapping("/reserve/edit/{id}")
    public ResponseEntity<FlyResponseDTO> putBooking(@RequestBody FlyRequestDTO flyRequestDTO,
                                                     @PathVariable Integer id) {
        return ResponseEntity.ok(
                flyService.flightBookingEdit(flyRequestDTO, id)
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

    // EP para ver todas las reservas

    @GetMapping("/reservations")
    public ResponseEntity<List<FlyRequestDTO>> bookingList() {
        return ResponseEntity.ok(
                flyService.getAllBooking()
        );
    }

    // EP eliminar un vuelo
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<ValidationDTO> deleteEntity(@PathVariable String code) {
        return ResponseEntity.ok(
                flyService.deleteEntity(code)
        );
    }

    // Falta eliminar una reserva de vuelo
    @DeleteMapping("/booking/delete/{id}")
    public ResponseEntity<ValidationDTO> deleteHotel(@PathVariable Integer id) {
        return ResponseEntity.ok(
                flyService.deleteBooking(id)
        );
    }

    //Rutas para requerimientos de Aye (parte individual Sprint3)

    //Requerimiento 1- Listado de vuelos por precios de mayor a menor para publicitar.

    @GetMapping("/mkt")
    public ResponseEntity<List<FlyDTO>> mktFlights() {
        return ResponseEntity.ok(
                flyService.mktflight()
        );
    }

    //Requerimiento 2- 3 vuelos + economicos.

    @GetMapping("/lowcost3")
    public ResponseEntity<List<FlyDTO>> treeFlights() {
        return ResponseEntity.ok(
                flyService.treeflight()
        );
    }

    //Requerimiento 3- Listado de vuelos por precios con rango elegido por usuario.
    @GetMapping("/{precioMax}/{precioMin}")
    public ResponseEntity<List<FlyDTO>> betweenListFly(@PathVariable Integer price)
        return ResponseEntity.ok(
            //    flyService.findByParameter(precioMax,precioMin)
            );
    }
    //Requerimiento 4- Listado de vuelos por calidad de servicio
//    @GetMapping("/quality/{type}")
//    public ResponseEntity<List<FlyDTO>> qualityListFly(@PathVariable String clase)
//        return ResponseEntity.ok(
//                //    flyService.findByParameter(precioMax,precioMin)
//                );


