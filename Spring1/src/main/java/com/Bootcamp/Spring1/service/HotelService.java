package com.Bootcamp.Spring1.service;


import com.Bootcamp.Spring1.dto.request.HotelRequestDTO;
import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HotelService {


    @Autowired //requerimos para enlazar con el repository y poder usar todas sus funcionalidades
    HotelRepository hotelRepository;

    /* Creamos un método "List" del contenido de HotelModel, pero que nos retorne el resultado de la
       función getHotels dentro de hotelRepository*/
    public  List<HotelModel> hotelList() {
        return hotelRepository.getHotels();
    }

    public List<HotelModel> availableListHotels(String city, String availableFromDate, String availableUntilDate) {
        if(city == null && availableFromDate == null && availableUntilDate == null) {

            return hotelList();
        }
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateFrom = LocalDate.parse(availableFromDate, f);
        LocalDate dateUntil = LocalDate.parse(availableUntilDate, f);
        return hotelRepository.availableListHotels(city, dateFrom, dateUntil);
    }



    public HotelRequestDTO bookingHotel (HotelRequestDTO hotelRequestDTO) {
       // System.out.println("Mostralo");
        return hotelRequestDTO;
    }

    /* private Double priceHotel () {
        return price;
    } */




}

