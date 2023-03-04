package com.Bootcamp.Spring1.repository;

import com.Bootcamp.Spring1.dto.request.HotelRequestDto;
import com.Bootcamp.Spring1.model.HotelModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class HotelRepository {
    private List<HotelModel> hotels;

    public HotelRepository() { //Creamos la data de los hoteles usando el constructor
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

        HotelModel hotel2 = new HotelModel();
        hotel2.setCodeHotel("CH-0003");
        hotel2.setName("Cataratas Hotel 2");
        hotel2.setCity("Puerto Iguazú");
        hotel2.setPrice(8200.00);
        hotel2.setRoomTipe("triple");
        hotel2.setAvailableFromDate("10/02/2022");
        hotel2.setAvailableUntilDate("23/03/2022");
        hotel2.setReserved(false);

        hotels.add(hotel2);

        HotelModel hotel3 = new HotelModel();
        hotel3.setCodeHotel("HB-0001");
        hotel3.setName("Hotel Bristol");
        hotel3.setCity("Buenos Aires");
        hotel3.setPrice(5435.00);
        hotel3.setAvailableFromDate("10/02/2022");
        hotel3.setAvailableUntilDate("19/03/2022");
        hotel3.setReserved(false);

        hotels.add(hotel3);

    }
/*Le indicamos al Repo que a través de una lista con de los atributos que tenemos en HotelModel, nos retorne
 todos los hoteles que tenemos en la variable hotel declarada arriba en los atributos de Repository*/
    public List<HotelModel> getHotels() {
        return hotels;
    }

}

