package com.bootcamp.spring1.service;

import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.response.FlyResponseDTO;
import com.bootcamp.spring1.exceptions.DateException;
import com.bootcamp.spring1.exceptions.DestinationException;
import com.bootcamp.spring1.model.FlyModel;
import com.bootcamp.spring1.repository.FlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateFrom = LocalDate.parse(departureDate, f);
        LocalDate dateUntil = LocalDate.parse(returnDate, f);
        if (dateUntil.isAfter(dateFrom)) {
            throw new DateException("La fecha de ida debe ser menor a la de vuelta.");
        }
        for (FlyModel fly : flightsList()) {
            if (fly.getOrigin().equals(origin) || fly.getDestination().equals(destination)) {
                return flyRepository.availableListFly(origin, destination, dateFrom, dateUntil);
            }
        }
        throw new DestinationException("El origen elegido no existe");
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

        if (flyRequestDTO.getFlightReservation().getDateTo().isBefore(flyRequestDTO.getFlightReservation().getDateFrom())) {
            throw new DateException("La fecha de ida debe ser menor a la de vuelta.");
        }
        for (FlyModel fly : flightsList()) {
            if (fly.getDestination().equals(flyRequestDTO.getFlightReservation().getDestination())) {
                return mensaje;
            }
        }
        throw new DestinationException("El destino elegido no existe");
    }
}

