package com.Bootcamp.Spring1.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HotelRequestDTO {
    // Datos de comprador
    private String username;
    private BookingDTO booking;

    // Metodos de pago

    // private String paymentMethod;

}
