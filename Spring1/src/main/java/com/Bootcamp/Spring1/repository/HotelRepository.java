package com.Bootcamp.Spring1.repository;


import com.Bootcamp.Spring1.model.HotelModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;


import lombok.Getter;
import lombok.Setter;


@Repository
@Getter
@Setter
public class HotelRepository {

    private List<HotelModel> hotels;

    public HotelRepository() { //Creamos la data de los hoteles usando el constructor
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.hotels = new ArrayList<>();

        HotelModel hotel1 = new HotelModel();
        hotel1.setCodeHotel("CH-0002");
        hotel1.setName("Cataratas Hotel");
        hotel1.setCity("Puerto Iguazú");
        hotel1.setPrice(6300.00);
        hotel1.setRoomTipe("doble");
        hotel1.setAvailableFromDate(LocalDate.parse("10/02/2022", f));
        hotel1.setAvailableUntilDate(LocalDate.parse("20/03/2022", f));
        hotel1.setReserved(false);

        hotels.add(hotel1);

        HotelModel hotel2 = new HotelModel();
        hotel2.setCodeHotel("CH-0003");
        hotel2.setName("Cataratas Hotel 2");
        hotel2.setCity("Puerto Iguazú");
        hotel2.setPrice(8200.00);
        hotel2.setRoomTipe("triple");
        hotel2.setAvailableFromDate(LocalDate.parse("10/02/2022", f));
        hotel2.setAvailableUntilDate(LocalDate.parse("23/03/2022", f));
        hotel2.setReserved(false);

        hotels.add(hotel2);

        HotelModel hotel3 = new HotelModel();
        hotel3.setCodeHotel("HB-0001");
        hotel3.setName("Hotel Bristol");
        hotel3.setCity("Buenos Aires");
        hotel3.setPrice(5435.00);
        hotel3.setAvailableFromDate(LocalDate.parse("10/02/2022", f));
        hotel3.setAvailableUntilDate(LocalDate.parse("19/03/2022", f));
        hotel3.setReserved(false);

        hotels.add(hotel3);

    }

    /*Le indicamos al Repo que a través de una lista con de los atributos que tenemos en HotelModel, nos retorne
     todos los hoteles que tenemos en la variable hotel declarada arriba en los atributos de Repository*/
    public List<HotelModel> getHotels() {
        return hotels;
    }

    public List<HotelModel> availableListHotels(String city, LocalDate availableFromDate, LocalDate availableUntilDate) {
        List<HotelModel> availableHotels = new ArrayList<>();
        for (HotelModel hotelModel : hotels) {
            if (availableFromDate.isAfter(hotelModel.getAvailableFromDate()) && availableUntilDate.isBefore(hotelModel.getAvailableUntilDate())
                    // && availableUntilDate.equals(hotelModel.getAvailableUntilDate())
                    && city.equals(hotelModel.getCity())) {
                availableHotels.add(hotelModel);
            }// si el if resulta verdadero, agregar a la lista ese hotel
        }
        return availableHotels;
    }

}

  /*  if (availableFromDate.isAfter(hotelModel.getAvailableFromDate) && (availableFromDate.isBefore(hotelModel.availableUntilDate)) {
            System.out.println("La fecha " + dateToCheck + " está dentro del rango de fechas.");
            } else if (dateToCheck.equals(startDate) || dateToCheck.equals(endDate)) {
            System.out.println("La fecha " + dateToCheck + " es igual a una de las fechas del rango.");
            } else {
            System.out.println("La fecha " + dateToCheck + " no está dentro del rango de fechas.");
            }
            }*/

//calcular rangos de fecha con el local Date