package com.bootcamp.spring1.service;


import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.exceptions.DateException;
import com.bootcamp.spring1.exceptions.DestinationException;
import com.bootcamp.spring1.exceptions.RoomTypeException;
import com.bootcamp.spring1.model.HotelModel;
import com.bootcamp.spring1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HotelService {


    @Autowired //requerimos para enlazar con el repository y poder usar todas sus funcionalidades
    HotelRepository hotelRepository;

    /* Creamos un método "List" del contenido de HotelModel, pero que nos retorne el resultado de la
       función getHotels dentro de hotelRepository*/
    public List<HotelModel> hotelList() {
        return hotelRepository.getHotels();
    }

    //VALIDACION --> verificar si el destino existe, se valida acá.
    //           --> Si el destino no existe se lanzala exepcion con el msj "destino no existe"
    public List<HotelModel> availableListHotels(String city, String availableFromDate, String availableUntilDate) {
        if (city == null && availableFromDate == null && availableUntilDate == null) {

            return hotelList();
        }
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateFrom = LocalDate.parse(availableFromDate, f);
        LocalDate dateUntil = LocalDate.parse(availableUntilDate, f);
        //ESTO ES UNA VALIDACION !!!
        if (dateUntil.isBefore(dateFrom)) {
            throw new DateException("La fecha de entrada debe ser menor a la de salida");
        }
        //For (inicialización;condición; incremento)
        for (HotelModel hotel : hotelList()) {
            if (hotel.getCity().equals(city)) {
                return hotelRepository.availableListHotels(city, dateFrom, dateUntil);
            }
        }
        throw new DestinationException("El destino elegido no existe");

    }

    public String bookingHotel(HotelRequestDTO hotelRequestDTO) {
        // Calcular el precio total, necesitamos precio hotel y cantidad de días
        // Precio Hotel: A través del HotelCode (que viene en el DTO) buscamos el repository el precio del hotel
        String code = hotelRequestDTO.getBooking().getHotelCode();
        Double lookPrice = hotelRepository.buscarPrecioHotel(code);

        // Cantidad de días: Utilizando las fechas del DTO calculamos la diferencia en días

        Period days = Period.between(hotelRequestDTO.getBooking().getDateFrom(),
                hotelRequestDTO.getBooking().getDateTo());
        Integer intDays = days.getDays();
        // Una vez se realice la reserva modificamos el atributo "reserved" del hotel (de false por defecto a true)
        // - Con un set modificamos el valor del atributo

        hotelRepository.hotelBooking(code);

        if (hotelRequestDTO.getBooking().getDateTo().isBefore(hotelRequestDTO.getBooking().getDateFrom())) {
            throw new DateException("La fecha de entrada debe ser menor a la de salida");
        }


        // Una vez tengamos los datos del precio total, crearíamos  response
        // Se podria generar un nuevo repositorio de reservas (en principio no haría falta)

        //Comparar la cantidad de pasajeros con el tipo de habitacion

        // si una habitacion es simple maximo sera una persona
        if (hotelRequestDTO.getBooking().getRoomType().equals("single") && hotelRequestDTO.getBooking().getPeopleAmount() > 1) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitacion es doble maximo seran dos personas
        if (hotelRequestDTO.getBooking().getRoomType().equals("doble") && hotelRequestDTO.getBooking().getPeopleAmount() > 2) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitacion es triple maximo seran tres personas
        if (hotelRequestDTO.getBooking().getRoomType().equals("triple") && hotelRequestDTO.getBooking().getPeopleAmount() > 3) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitacion es mmultiple maximo seran siete personas
        if (hotelRequestDTO.getBooking().getRoomType().equals("Múltiple") && hotelRequestDTO.getBooking().getPeopleAmount() > 7) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // Si ingresa una habitación distinta a las disponibles
        if (!hotelRequestDTO.getBooking().getRoomType().equals("Múltiple") && !hotelRequestDTO.getBooking().getRoomType().equals("triple") && !hotelRequestDTO.getBooking().getRoomType().equals("doble") && !hotelRequestDTO.getBooking().getRoomType().equals("single")) {
            throw new RoomTypeException("Debe ingresar un tipo de habitación valido");
        }

        //For (inicialización;condición; incremento)
        for (HotelModel hotel : hotelList()) {
            if (hotel.getCity().equals(hotelRequestDTO.getBooking().getDestination()))
            {
                return "El precio de la reserva es de $" + (lookPrice * intDays) + " por " + intDays + " dias de " +
                        "estadía";
            }
        }

        throw new DestinationException("El destino elegido no existe");

    }

    public HotelResponseDTO priceHotel(HotelResponseDTO hotelResponseDTO) {
        return hotelResponseDTO;
    }

}

