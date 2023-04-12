package com.bootcamp.spring1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlyDTO {
    private Integer id;
    private String flightNumber;
    private String origin;
    private String destination;
    private String seatType;
    private int flightPrice;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateTo;
    private String reservation;
}
