package com.bootcamp.spring1.controller;


import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.model.HotelModel;
import com.bootcamp.spring1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class HotelController {
    @Autowired //requerimos para enlazar con el service y poder usar todas sus funcionalidades
    HotelService hotelService;

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
    public String booking(@Valid @RequestBody HotelRequestDTO datosReserva) {
        return hotelService.bookingHotel(datosReserva);
    }

    //creamos esta ruta como medio de verificacion para controlar los datos que se ingresan (postman)
    @GetMapping("/api/v1/booking")
    public HotelResponseDTO precio(@Valid @RequestBody HotelResponseDTO precioReserva) {
        return hotelService.priceHotel(precioReserva);
    }

}