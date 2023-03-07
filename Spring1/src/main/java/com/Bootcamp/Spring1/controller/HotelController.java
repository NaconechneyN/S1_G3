package com.Bootcamp.Spring1.controller;


import com.Bootcamp.Spring1.dto.request.HotelRequestDTO;
import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    @Autowired //requerimos para enlazar con el service y poder usar todas sus funcionalidades
    HotelService hotelService;

    /*@GetMapping("/api/v1/hotels")
    public List<HotelModel> listHotel() {
        return hotelService.hotelList();
    }*/


    @PostMapping("/api/v1/booking")
    public HotelRequestDTO booking(@RequestBody HotelRequestDTO datosReserva){
        return hotelService.bookingHotel(datosReserva);
    }
    //Al poner esta ruta nos muestra la lista de hoteles

// listado de todos los hoteles disponibles en un determinado
//rango de fechas y según el destino seleccionado

    @GetMapping("/api/v1/hotels")
    public List<HotelModel> listHotelAvailable(@RequestParam(required = false) String destination,
                                                @RequestParam(required = false) String dateFrom,
                                                @RequestParam(required = false) String dateTo) {
        return hotelService.availableListHotels(destination, dateFrom, dateTo);
    }

}