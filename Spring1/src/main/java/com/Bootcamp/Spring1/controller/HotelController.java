package com.Bootcamp.Spring1.controller;


import com.Bootcamp.Spring1.dto.request.HotelRequestDTO;
import com.Bootcamp.Spring1.dto.response.HotelResponseDTO;
import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    @Autowired //requerimos para enlazar con el service y poder usar todas sus funcionalidades
    HotelService hotelService;
    @GetMapping("/api/v1/hotels")
        public List<HotelModel> listHotel() {
            return hotelService.hotelList();
        }

    @PostMapping("/api/v1/booking")
    public String booking(@RequestBody HotelRequestDTO datosReserva){
        return hotelService.bookingHotel(datosReserva);
    }

    /* @GetMapping("/api/v1/booking")
    public HotelResponseDTO precio(@RequestBody HotelResponseDTO precioReserva){
        return hotelService.priceHotel(precioReserva);
    } */

}



//Al poner esta ruta nos muestra la lista de hoteles
