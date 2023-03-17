package com.bootcamp.spring1.dto.request.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class HotelRequestDTO {
    // Datos de comprador
    private String username;
    @Valid
    private BookingDTO booking;

}
