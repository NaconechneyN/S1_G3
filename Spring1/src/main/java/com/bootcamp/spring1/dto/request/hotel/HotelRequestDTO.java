package com.bootcamp.spring1.dto.request.hotel;

import lombok.*;

import javax.validation.Valid;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class HotelRequestDTO {
    // Datos de comprador
    private String username;
    @Valid
    private BookingDTO booking;
}
