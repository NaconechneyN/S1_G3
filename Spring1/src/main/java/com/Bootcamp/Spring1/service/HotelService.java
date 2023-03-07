package com.Bootcamp.Spring1.service;


import com.Bootcamp.Spring1.dto.request.HotelRequestDTO;
import com.Bootcamp.Spring1.dto.response.HotelResponseDTO;
import com.Bootcamp.Spring1.model.HotelModel;
import com.Bootcamp.Spring1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
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



    public Double bookingHotel (HotelRequestDTO hotelRequestDTO) {
    // Calcular el precio total, necesitamos precio hotel y cantidad de días
        // Precio Hotel: A través del HotelCode (que viene en el DTO) buscamos el repository el precio del hotel
        String code = hotelRequestDTO.getBooking().getHotelCode();
        Double lookPrice = hotelRepository.buscarPrecioHotel(code);

        // Cantidad de días: Utilizando las fechas del DTO calculamos la diferencia en días
            // - int cantidadDias = Period.between(dateFrom, dateTo).getDays();
        Period days = Period.between(hotelRequestDTO.getBooking().getDateFrom(),
                hotelRequestDTO.getBooking().getDateTo());
        Integer intDays = days.getDays();
        // Una vez se realice la reserva modificamos el atributo "reserved" del hotel (de false por defecto a true)
            // - Con un set modificamos el valor del atributo

        hotelRepository.hotelBooking(code);

        // Una vez tengamos los datos del precio total, crearíamos el response
        // Se podria generar un nuevo repositorio de reservas (en principio no haría falta)

        Double total = lookPrice * intDays;

        return total;
    }

    public HotelResponseDTO priceHotel (HotelResponseDTO hotelResponseDTO){
        return hotelResponseDTO;
    }

}
