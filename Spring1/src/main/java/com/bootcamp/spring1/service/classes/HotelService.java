package com.bootcamp.spring1.service.classes;


import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.dto.request.hotel.BookingDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.entity.BookingHotel;
import com.bootcamp.spring1.entity.Hotel;
import com.bootcamp.spring1.exceptions.IdException;
import com.bootcamp.spring1.exceptions.NullException;
import com.bootcamp.spring1.exceptions.RoomTypeException;
import com.bootcamp.spring1.repository.IBookingHotelRepository;
import com.bootcamp.spring1.repository.IHotelRepository;
import com.bootcamp.spring1.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements ICrudService<HotelDTO, Integer> {

    @Autowired //requerimos para enlazar con el repository y poder usar todas sus funcionalidades
    IHotelRepository hotelRepository;
    @Autowired
    IBookingHotelRepository bookingHotelRepository;
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

    //Método para crear la reserva de un hotel
    public HotelResponseDTO hotelBooking(HotelRequestDTO hotelRequestDTO) {
        // si una habitación es simple máximo será una persona
        if (hotelRequestDTO.getBooking().getRoomType().equals("single") && hotelRequestDTO.getBooking().getPeopleAmount() > 1) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitación es doble máximo seran dos personas
        if (hotelRequestDTO.getBooking().getRoomType().equals("doble") && hotelRequestDTO.getBooking().getPeopleAmount() > 2) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitación es triple máximo seran tres personas
        if (hotelRequestDTO.getBooking().getRoomType().equals("triple") && hotelRequestDTO.getBooking().getPeopleAmount() > 3) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // si una habitación es múltiple máximo seran siete personas
        if (hotelRequestDTO.getBooking().getRoomType().equals("Múltiple") && hotelRequestDTO.getBooking().getPeopleAmount() > 7) {
            throw new RoomTypeException("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");
        }
        // Si ingresa una habitación distinta a las disponibles
        if (!hotelRequestDTO.getBooking().getRoomType().equals("Múltiple") && !hotelRequestDTO.getBooking().getRoomType().equals("triple")
                && !hotelRequestDTO.getBooking().getRoomType().equals("doble")
                && !hotelRequestDTO.getBooking().getRoomType().equals("single")) {
            throw new RoomTypeException("Debe ingresar un tipo de habitación valido");
        }

        var hotelEntity = hotelRepository.findByHotelCode(hotelRequestDTO.getBooking().getHotelCode());
        if (hotelEntity != null) {
            hotelEntity.setBooked(true);
            hotelRepository.save(hotelEntity);

            var bookedEntity = mapper.map(hotelRequestDTO.getBooking(), BookingHotel.class);
            bookedEntity.setUsername(hotelRequestDTO.getUsername());
            bookingHotelRepository.save(bookedEntity);

            //Calculamos el período de días entre las fechas seleccionadas
            Period days = Period.between(hotelRequestDTO.getBooking().getDateFrom(),
                    hotelRequestDTO.getBooking().getDateTo());
            Integer intDays = days.getDays();

            //buscamos el precio del hotel en la entidad Hotel
            var price = hotelEntity.getPrice();

            //Calculamos el precio total
            double priceTotal = price * intDays;

            //Devolvemos DTO con mensaje y el precio total
            HotelResponseDTO mensaje = new HotelResponseDTO();
            mensaje.setMensaje("El monto de la reserva es de: ");
            mensaje.setTotal(priceTotal);

            return mensaje;
        } else
            throw new IdException("No se pudo hacer la reserva");

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

    //Método para obtener la lista de todas las reservas
    public List<HotelRequestDTO> getAllBooking() {
        // buscar todos los resultados en el repo
        var listBookingEntity = bookingHotelRepository.findAll();
        // luego convertir de entidad a DTO
        return listBookingEntity.stream().map(
                        reserva -> {
                            var booking = mapper.map(reserva, BookingDTO.class);
                            var hotelRequestDTO = new HotelRequestDTO();
                            hotelRequestDTO.setBooking(booking);
                            hotelRequestDTO.setUsername(reserva.getUsername());
                            return hotelRequestDTO;
                        }
                )
                .collect(Collectors.toList());
    }

    //Método para borrar un hotel
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

    //Método para borrar una reserva
    public ValidationDTO deleteBooking(Integer id) {
        // buscar el dato en la base de datos y asegurarnos que exista
        if (bookingHotelRepository.existsById(id)) {
            bookingHotelRepository.deleteById(id);
            return ValidationDTO.builder()
                    .message("Se eliminó la reserva satisfactoriamente")
                    .action("DELETATION")
                    .build();
        } else {

            return ValidationDTO.builder()
                    .message("No se encontró una reserva con el id: " + id)
                    .action("DELETATION")
                    .build();
        }
    }

    //-----> Barby: Método para listar hoteles pet friendly.
    public List<HotelDTO> petHotel() {
        var listPetEntity = hotelRepository.findByPetFriendlyTrue();
        if (!listPetEntity.isEmpty()) {
            return listPetEntity.stream().map(
                            petsHotels -> mapper.map(petsHotels, HotelDTO.class)
                    )
                    .collect(Collectors.toList());
        } else {
            throw new NullException("No se encontró hoteles que acepten mascotas");

        }

    }

}
