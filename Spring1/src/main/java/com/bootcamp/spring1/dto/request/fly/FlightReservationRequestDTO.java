package com.bootcamp.spring1.dto.request.fly;

import com.bootcamp.spring1.dto.request.HostDTO;
import com.bootcamp.spring1.dto.request.PaymentsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightReservationRequestDTO {
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)

    public LocalDate dateTo;
    private String origin;
    private String destination;
    private String flightNumber;
    @NotNull
    @Positive(message = "La cantidad de personas debe ser un valor numérico mayor a 0")
    private Integer seats;
    private String seatType;

    private List<@Valid HostDTO> people;
    private PaymentsDTO paymentMethod;
}
