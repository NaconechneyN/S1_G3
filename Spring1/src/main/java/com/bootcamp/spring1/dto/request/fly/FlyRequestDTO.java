package com.bootcamp.spring1.dto.request.fly;

import com.bootcamp.spring1.dto.request.PaymentsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class FlyRequestDTO {
    @NotEmpty(message = "Se debe ingresar el nombre de usuario")
    private String userName;
    @Valid
    private FlightReservationDTO flightReservation;
    private PaymentsDTO payments;

}
