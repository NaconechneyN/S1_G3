package com.bootcamp.spring1.service.classes;

import com.bootcamp.spring1.dto.FlyDTO;
import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.dto.request.fly.FlyRequestDTO;
import com.bootcamp.spring1.dto.response.FlyResponseDTO;
import com.bootcamp.spring1.entity.BookingFlight;
import com.bootcamp.spring1.entity.Flight;
import com.bootcamp.spring1.exceptions.DateException;
import com.bootcamp.spring1.exceptions.IdException;
import com.bootcamp.spring1.repository.IBookingFlightRepository;
import com.bootcamp.spring1.repository.IFlyRepository;
import com.bootcamp.spring1.service.generics.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlyService implements ICrudService<FlyDTO, Integer> {
    @Autowired
    IFlyRepository flyRepository;
    @Autowired
    IBookingFlightRepository bookingFlightRepository;

    ModelMapper mapper = new ModelMapper();

    // Método para guardar un vuelo nuevo
    @Override
    public FlyDTO saveEntity(FlyDTO objectDTO) {
        // mappear de dto a entity para llevar al repo
        var entity = mapper.map(objectDTO, Flight.class);
        // guardar
        flyRepository.save(entity);
        // mappear de entity a dto para llevar al controller
        return mapper.map(entity, FlyDTO.class);
    }

    //Método para guardar una nueva reserva de vuelo
    public FlyResponseDTO flightBooking(FlyRequestDTO flyRequestDTO) {
        if (flyRequestDTO.getFlightReservation().getDateTo().isBefore(flyRequestDTO.getFlightReservation().getDateFrom())) {
            throw new DateException("La fecha de ida debe ser menor a la de vuelta.");
        }

        var flightEntity = flyRepository.findByFlightNumber(flyRequestDTO.getFlightReservation().getFlightNumber());
        if (flightEntity != null) {
            flightEntity.setReservation(true);
            flyRepository.save(flightEntity);
        }

        var bookedEntity = mapper.map(flyRequestDTO.getFlightReservation(), BookingFlight.class);
        bookedEntity.setUsername(flyRequestDTO.getUserName());
        bookingFlightRepository.save(bookedEntity);

        //buscamos el precio del hotel en la entidad Vuelo
        var price = flightEntity.getFlightPrice();

        // calculamos los asientos reservados
        var seat = flyRequestDTO.getFlightReservation().getSeats();

        // Calculamos el precio total
        Integer priceTotal = price * seat;

        // Devolvemos DTO con el mensaje y el precio total
        FlyResponseDTO mensaje = new FlyResponseDTO();
        mensaje.setMensaje("El monto total de la reserva del vuelo es de: ");
        mensaje.setTotal(priceTotal);

        return mensaje;

    }


    // Método para obtener una lista de todos los vuelos
    @Override
    public List<FlyDTO> getAllEntities() {
        // buscar todos los resultados en el repo
        var listFlightsEntity = flyRepository.findAll();
        // luego convertir de entidad a DTO
        return listFlightsEntity.stream().map(
                flight -> mapper.map(flight, FlyDTO.class)
        ).collect(Collectors.toList());
    }

    //Método para obtener un vuelo por parámetros.
    public List<FlyDTO> findByParameter(LocalDate dateFrom, LocalDate dateTo, String origin, String destination) {
        var listEntity =
                flyRepository.findByDateFromLessThanEqualAndDateToGreaterThanEqualAndOriginEqualsAndDestinationEquals
                        (dateFrom, dateTo, origin, destination);
        if (listEntity != null) {
            return listEntity.stream().map(
                            flightsParameter -> mapper.map(flightsParameter, FlyDTO.class)
                    )
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Favor ingresar datos válidos");
        }
    }

    @Override
    public ValidationDTO deleteEntity(String code) {
        // buscar el dato en la bade de datos y asegurarnos que exista
        var flight = flyRepository.findByFlightNumber(code);
        // eliminar efectivamente
        if (flight != null)
            flyRepository.delete(flight);
        else
            throw new IdException("No se pudo encontrar vuelo con el código: " + code);
        // devolver el mensaje DTO
        return ValidationDTO.builder()
                .message("Se elimino el vuelo con el código: " + code)
                .action("DELETATION")
                .build();
    }

    /*

    //Creamos un método "List" del contenido de HotelModel, pero que nos retorne el resultado de la
     //función getHotels dentro de hotelRepository
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
    */
}

