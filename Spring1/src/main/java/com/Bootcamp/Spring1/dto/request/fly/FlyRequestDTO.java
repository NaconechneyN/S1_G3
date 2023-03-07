package com.Bootcamp.Spring1.dto.request.fly;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlyRequestDTO {
    private String userName;
    private FlightReservationRequestDTO flightReservation;
    private PaymentMethodRequestDTO paymentMethod;

}
