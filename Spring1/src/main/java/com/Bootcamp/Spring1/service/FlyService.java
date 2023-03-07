package com.Bootcamp.Spring1.service;

import org.springframework.stereotype.Service;

@Service
public class FlyService {

    // Calcular el precio total, necesitamos precio fly y cantidad de días
    // Precio Fly: A través del HotelCode (que viene en el DTO) buscamos el repository el precio del hotel
    // Cantidad de días: Utilizando las fechas del DTO calculamos la diferencia en días
     // - int cantidadDias = Period.between(dateFrom, dateTo).getDays();
    // Una vez se realice la reserva modificamos el atributo "reserved" del hotel (de false por defecto a true)
         // - Con un set modificamos el valor del atributo

    // Una vez tengamos los datos del precio total, crearíamos el response
    // Se podria generar un nuevo repositorio de reservas (en principio no haría falta)
}
