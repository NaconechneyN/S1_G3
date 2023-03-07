package com.Bootcamp.Spring1.service;

import com.Bootcamp.Spring1.model.FlyModel;
import com.Bootcamp.Spring1.repository.FlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
        return flyRepository.availableListFly(origin,destination,dateFrom,dateUntil);
    }





    // Calcular el precio total, necesitamos precio fly y cantidad de días
    // Precio Fly: A través del HotelCode (que viene en el DTO) buscamos el repository el precio del hotel
    // Cantidad de días: Utilizando las fechas del DTO calculamos la diferencia en días
     // - int cantidadDias = Period.between(dateFrom, dateTo).getDays();
    // Una vez se realice la reserva modificamos el atributo "reserved" del hotel (de false por defecto a true)
         // - Con un set modificamos el valor del atributo

    // Una vez tengamos los datos del precio total, crearíamos el response
    // Se podria generar un nuevo repositorio de reservas (en principio no haría falta)
}
