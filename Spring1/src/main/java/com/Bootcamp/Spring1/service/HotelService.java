package com.Bootcamp.Spring1.service;

import com.Bootcamp.Spring1.dto.request.HotelRequestDto;
import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

