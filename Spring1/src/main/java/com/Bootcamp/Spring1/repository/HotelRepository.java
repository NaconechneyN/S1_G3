package com.Bootcamp.Spring1.repository;

import com.Bootcamp.Spring1.dto.request.HotelRequestDto;
import com.Bootcamp.Spring1.model.HotelModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class HotelRepository {
    private List<HotelModel> hotels;

    public HotelRepository() {
        this.hotels = new ArrayList<>();

        HotelModel hotel1= new HotelModel();
        hotel1.setCodeHotel("CH-0002");
        hotel1.setName("Cataratas Hotel");
        hotel1.setCity("Puerto Iguazú");
        hotel1.setPrice(6300.00);
        hotel1.setRoomTipe("doble");
        hotel1.setAvailableFromDate("10/02/2022");
        hotel1.setAvailableUntilDate("20/03/2022");
        hotel1.setReserved(false);

        hotels.add(hotel1);
    }

    public List<HotelModel> getHotels() {
        return hotels;
    }
}

