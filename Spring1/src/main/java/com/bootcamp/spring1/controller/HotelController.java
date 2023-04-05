package com.bootcamp.spring1.controller;

import com.bootcamp.spring1.dto.HotelDTO;
import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.dto.request.hotel.HotelRequestDTO;
import com.bootcamp.spring1.dto.response.HotelResponseDTO;
import com.bootcamp.spring1.service.classes.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/hotels")
public class HotelController {
    @Autowired //requerimos para enlazar con el service y poder usar todas sus funcionalidades
    HotelService hotelService;

    //EP para generar un nuevo hotel
    @PostMapping("/new")
    public ResponseEntity<HotelDTO> create(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(
                hotelService.saveEntity(hotelDTO)
        );
    }
    //EP para reservar Hotel
    @PostMapping("/booking/new")
    public HotelResponseDTO booking(@Valid @RequestBody HotelRequestDTO datosReserva) {
        return hotelService.hotelBooking(datosReserva);
    }

    //EP para editar Hotel
    @PutMapping("/edit/{code}")
    public ResponseEntity<HotelDTO> putHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(
                hotelService.saveEntity(hotelDTO)
        );
    }

    // EP de editar una reserva de hotel.
    @PutMapping("/booking/edit/{code}")
    public ResponseEntity<HotelResponseDTO> putBooking(@RequestBody HotelRequestDTO hotelRequestDTO) {
        return ResponseEntity.ok(
                hotelService.hotelBooking(hotelRequestDTO)
        );
    }

    //EP para consultar todos los Hoteles
    @GetMapping("/all")
    public ResponseEntity<List<HotelDTO>> hotelList() {
        return ResponseEntity.ok(
                hotelService.getAllEntities()
        );
    }

    //EP para consultar todos los Hoteles pasando un parámetro
    @GetMapping("/")
    public ResponseEntity<List<HotelDTO>> availableListHotels(
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam(required = false) String destination) {
        return ResponseEntity.ok(
                hotelService.findByParameter(dateFrom, dateTo, destination)
        );

    }

    //EP para consultar la lista de todas las reservas de hoteles.
    @GetMapping("/bookings")
    public ResponseEntity<List<HotelRequestDTO>> bookinglList() {
        return ResponseEntity.ok(
                hotelService.getAllBooking()
        );
    }

    //EP para eliminar un Hotel
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<ValidationDTO> deleteHotel(@PathVariable String code) {
        return ResponseEntity.ok(
                hotelService.deleteEntity(code)
        );
    }

    //EP para eliminar de una reserva
    @DeleteMapping("/booking/delete/{id}")
    public ResponseEntity<ValidationDTO> deleteHotel(@PathVariable Integer id) {
        return ResponseEntity.ok(
                hotelService.deleteBooking(id)
        );
    }

    //EP Francisco: filtro de hoteles según un rango de precios
    @GetMapping ("/findHotelPrice/")
    public ResponseEntity<List<HotelDTO>> findByPrice (
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return ResponseEntity.ok(
                hotelService.findByPrice(minPrice, maxPrice)
        );
    }











    /*

    // listado de todos los hoteles disponibles en un determinado rango de fechas y según el destino seleccionado

    //Validaciones --> comparar las fechas en el controler entrada<salida, si hay error se lanza excepción.
    //              -->corregir formato de fechas a dd/mm/aaaa en vez de guiones.

    @GetMapping("/api/v1/hotels")
    public List<HotelModel> listHotelAvailable(@NotEmpty @RequestParam(required = false) String destination,
                                               @NotEmpty  @RequestParam(required = false) String dateFrom,
                                               @NotEmpty  @RequestParam(required = false) String dateTo)
                //Comparar destino y fechas, ver service.
    {
        return hotelService.availableListHotels(destination, dateFrom, dateTo);


    //creamos esta ruta como medio de verificacion para controlar los datos que se ingresan (postman)
    @GetMapping("/api/v1/booking")
    public HotelResponseDTO precio(@Valid @RequestBody HotelResponseDTO precioReserva) {
        return hotelService.priceHotel(precioReserva);
    }
*/
}