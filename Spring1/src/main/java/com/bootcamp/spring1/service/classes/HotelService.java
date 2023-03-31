package com.bootcamp.spring1.service.classes;


import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.entity.Hotel;
//import com.bootcamp.spring1.repository.HotelRepository;
import com.bootcamp.spring1.exceptions.IdException;
import com.bootcamp.spring1.repository.IHotelRepository;
import com.bootcamp.spring1.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements ICrudService<HotelDTO, Integer> {


    @Autowired //requerimos para enlazar con el repository y poder usar todas sus funcionalidades
    IHotelRepository hotelRepository;

    ModelMapper mapper = new ModelMapper();

    //Método para crear un hotel
    @Override
    public HotelDTO saveEntity(HotelDTO objectDTO) {
        // mappear de dto a entity para llevar al repo
        var entity = mapper.map(objectDTO, Hotel.class);
        // guardar
        hotelRepository.save(entity);
        // mappear de entity a dto para llevar al controller
        return mapper.map(entity, HotelDTO.class);
    }

    //Método para obtener la lista de todos los hoteles
    @Override
    public List<HotelDTO> getAllEntities() {
        // buscar todos los resultados en el repo
        var listHotelsEntity = hotelRepository.findAll();
        // luego convertir de entidad a DTO
        return listHotelsEntity.stream().map(
                        hoteles -> mapper.map(hoteles, HotelDTO.class)
                )
                .collect(Collectors.toList());
    }

    //Método para obtener un hotel por parámetros.
    public List<HotelDTO> findByParameter(LocalDate dateFrom, LocalDate dateTo, String destination) {
        var listEntity = hotelRepository.findByDateFromLessThanEqualAndDateToGreaterThanEqualAndCityEquals
                (dateFrom, dateTo, destination);
       if (listEntity != null) {
            return listEntity.stream().map(
                            hotelesParameter -> mapper.map(hotelesParameter, HotelDTO.class)
                    )
                    .collect(Collectors.toList());
       } else {
            throw new RuntimeException("Favor ingresar datos válidos");

        }

    }

    @Override
    public ValidationDTO deleteEntity(String code) {
        // buscar el dato en la base de datos y asegurarnos que exista
        var hotel = hotelRepository.findByHotelCode(code);
        // eliminar efectivamente
        if (hotel != null)
            hotelRepository.delete(hotel);
        else
            throw new IdException("No se pudo encontrar hotel con el código: " + code);
        // devolver el mensaje DTO
        return ValidationDTO.builder()
                .message("Se elimino el hotel con el código: " + code)
                .action("DELETATION")
                .build();
    }

    public ValidationDTO putEntity(String code) {
        // buscar el dato en la base de datos y asegurarnos que exista
        var hotel = hotelRepository.findByHotelCode(code);
        // eliminar efectivamente
        if (hotel != null)
            hotelRepository.save(hotel);
        else
            throw new IdException("No se pudo modificar hotel con el código: " + code);
        // devolver el mensaje DTO
        return ValidationDTO.builder()
                .message("Se modificó el hotel con el código: " + code)
                .action("EDITATION")
                .build();
    }


    /*
    public HotelResponseDTO bookingHotel(HotelRequestDTO hotelRequestDTO) {
        // Calcular el precio total, necesitamos precio hotel y cantidad de días
        // Precio Hotel: A través del HotelCode (que viene en el DTO) buscamos el repository el precio del hotel
       // String code = hotelDTO.getBooking().getHotelCode();
        var codeHotel = hotelRepository.findByHotelCode(code);
        //Double lookPrice = hotelRepository.buscarPrecioHotel(code);
        var priceHotel = hotelRepository.findByHotelPrice(price);

        // Cantidad de días: Utilizando las fechas del DTO calculamos la diferencia en días

        Period days = Period.between(hotelDTO.getBooking().getDateFrom(),
                hotelDTO.getBooking().getDateTo());
        Integer intDays = days.getDays();
        // Una vez se realice la reserva modificamos el atributo "reserved" del hotel (de false por defecto a true)
        // - Con un set modificamos el valor del atributo

        hotelRepository.hotelBooking(code);

        if (hotelDTO.getBooking().getDateTo().isBefore(hotelDTO.getBooking().getDateFrom())) {
            throw new DateException("La fecha de entrada debe ser menor a la de salida");
        }


        // Una vez tengamos los datos del precio total, crearíamos  response
        // Se podria generar un nuevo repositorio de reservas (en principio no haría falta)

        //Comparar la cantidad de pasajeros con el tipo de habitacion

        // si una habitacion es simple maximo sera una persona
        if (hotelDTO.getBooking().getRoomType().equals("single") && hotelDTO.getBooking().getPeopleAmount() > 1) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitacion es doble maximo seran dos personas
        if (hotelDTO.getBooking().getRoomType().equals("doble") && hotelDTO.getBooking().getPeopleAmount() > 2) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitacion es triple maximo seran tres personas
        if (hotelDTO.getBooking().getRoomType().equals("triple") && hotelDTO.getBooking().getPeopleAmount() > 3) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitacion es mmultiple maximo seran siete personas
        if (hotelDTO.getBooking().getRoomType().equals("Múltiple") && hotelDTO.getBooking().getPeopleAmount() > 7) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // Si ingresa una habitación distinta a las disponibles
        if (!hotelDTO.getBooking().getRoomType().equals("Múltiple") && !hotelDTO.getBooking().getRoomType().equals("triple") && !hotelDTO.getBooking().getRoomType().equals("doble") && !hotelDTO.getBooking().getRoomType().equals("single")) {
            throw new RoomTypeException("Debe ingresar un tipo de habitación valido");
        }

        double priceTotal = lookPrice * intDays;
        //Devolvemos DTO con mensaje y el precio total
        HotelResponseDTO mensaje = new HotelResponseDTO();
        mensaje.setMensaje("El monto de la reserva es de: ");
        mensaje.setTotal(priceTotal);

        //For (inicialización;condición; incremento)
        for (HotelModel hotel : hotelList()) {
            if (hotel.getCity().equals(hotelDTO.getBooking().getDestination())) {
                return mensaje;
            }
        }

        throw new DestinationException("El destino elegido no existe");

    }

    public HotelResponseDTO priceHotel(HotelResponseDTO hotelResponseDTO) {
        return hotelResponseDTO;
    }
*/

}

