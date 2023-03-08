package com.Bootcamp.Spring1.service;

import com.Bootcamp.Spring1.dto.request.fly.FlyRequestDTO;
import com.Bootcamp.Spring1.dto.response.FlyResponseDTO;
import com.Bootcamp.Spring1.model.FlyModel;
import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.repository.FlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlyService {
    @Autowired //requerimos para enlazar con el repository y poder usar todas sus funcionalidades
    FlyRepository flyRepository;

    /* Creamos un método "List" del contenido de HotelModel, pero que nos retorne el resultado de la
       función getHotels dentro de hotelRepository*/
    public List<FlyModel> flightsList() {
        return flyRepository.getFlights();
    }

    public List<FlyModel> availableListFly(String departureDate, String returnDate, String origin,
                                           String destination) {
        if (origin == null && destination == null && departureDate == null && returnDate == null) {

            return flightsList();
        }
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateFrom = LocalDate.parse(departureDate, f);
        LocalDate dateUntil = LocalDate.parse(returnDate, f);
        return flyRepository.availableListFly(origin, destination, dateFrom, dateUntil);
    }


    public FlyResponseDTO reservationFlight(FlyRequestDTO flyRequestDTO) {
        //Calcular precio
        Integer price = flyRepository.searchFlightPrice(flyRequestDTO.getFlightReservation().getFlightNumber());
        //Calcular cuantas personas hay
        Integer seatsPerson = flyRequestDTO.getFlightReservation().getSeats();
        //Calculamos el precio total
        Integer priceTotal = price * seatsPerson;
        //Devolvemos DTO con mensaje y el precio total
        FlyResponseDTO mensaje = new FlyResponseDTO();
        mensaje.setMensaje("El monto total del vuelo es de: ");
        mensaje.setTotal(priceTotal);

        return mensaje;
    }

}

