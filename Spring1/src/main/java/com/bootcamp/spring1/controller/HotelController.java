package com.bootcamp.spring1.controller;


import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.service.classes.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/hotels")
public class HotelController {
    @Autowired //requerimos para enlazar con el service y poder usar todas sus funcionalidades
    HotelService hotelService;

    @PostMapping("/new/")
    public ResponseEntity<HotelDTO> create(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(
                hotelService.saveEntity(hotelDTO)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<HotelDTO>> hotelList() {
        return ResponseEntity.ok(
                hotelService.getAllEntities()
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<HotelDTO>> availableListHotels(
           @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
           @RequestParam(required = false) String destination) {
        return ResponseEntity.ok(
                hotelService.findByParameter(dateFrom, dateTo, destination)
        );

    }
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<ValidationDTO> deleteHotel(@PathVariable String code) {
        return ResponseEntity.ok(
                hotelService.deleteEntity(code)
        );
    }
    @PutMapping ("/edit/{code}")
    public ResponseEntity<ValidationDTO> putHotel(@PathVariable String code) {
        return ResponseEntity.ok(
                hotelService.putEntity(code)
        );
    }
    /*

    // listado de todos los hoteles disponibles en un determinado rango de fechas y según el destino seleccionado

    //Validaciones --> comparar las fechas en el controler entrada<salida, si hay error se lanza excepción.
    //              -->corregir formato de fechas a dd/mm/aaaa en vez de guiones.

    @GetMapping("/api/v1/hotels")
    public List<HotelModel> listHotelAvailable(@NotEmpty @RequestParam(required = false) String destination,
                                               @NotEmpty  @RequestParam(required = false) String dateFrom,
                                               @NotEmpty  @RequestParam(required = false) String dateTo)
                //Comparar destino y fechas, ver service.
    {
        return hotelService.availableListHotels(destination, dateFrom, dateTo);
    }

    @PostMapping("/api/v1/booking")
    public HotelResponseDTO booking(@Valid @RequestBody HotelDTO datosReserva) {
        return hotelService.bookingHotel(datosReserva);
    }

    //creamos esta ruta como medio de verificacion para controlar los datos que se ingresan (postman)
    @GetMapping("/api/v1/booking")
    public HotelResponseDTO precio(@Valid @RequestBody HotelResponseDTO precioReserva) {
        return hotelService.priceHotel(precioReserva);
    }
*/
}