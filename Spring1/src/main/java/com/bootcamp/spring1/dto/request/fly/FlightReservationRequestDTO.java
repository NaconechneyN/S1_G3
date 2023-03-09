package com.bootcamp.spring1.dto.request.fly;

import com.bootcamp.spring1.dto.request.HostDTO;
import com.bootcamp.spring1.dto.request.PaymentsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightReservationRequestDTO {
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate dateFrom;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate dateTo;
    private String origin;
    private String destination;
    private String flightNumber;
    private Integer seats;
    private String seatType;
    private List<HostDTO> people;
    private PaymentsDTO paymentMethod;
}
