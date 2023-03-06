package com.Bootcamp.Spring1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HotelRequestDTO {
    // Datos de comprador
    private String username;
    private BookingDTO booking;



}
