package com.Bootcamp.Spring1.service;

import com.Bootcamp.Spring1.dto.request.HotelRequestDto;
import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;
    public  List<HotelModel> hotelList() {
        return hotelRepository.getHotels();
    }
}

