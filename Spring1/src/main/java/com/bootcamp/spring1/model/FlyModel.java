package com.bootcamp.spring1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class FlyModel {
    private String flyNumber;
    private String origin;
    private String destination;
    private String seatType;
    private int pricePerson;
    private LocalDate departureDate;
    private LocalDate returnDate;
}
