package com.Bootcamp.Spring1.dto.request.fly;

import com.Bootcamp.Spring1.dto.request.HostDTO;
import com.Bootcamp.Spring1.dto.request.PaymentsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightReservationRequestDTO {
    public LocalDate dateFrom;
    public LocalDate dateTo;
    public String origin;
    public String destination;
    public String flightNumber;
    public String seats;
    public String seatType;
    public HostDTO people; //ver con Marco si se pasa así el DTO
    public PaymentsDTO paymentMethod;
}
