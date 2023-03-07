package com.Bootcamp.Spring1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FlyModel {
    private String flyNumber;
    private String origin;
    private String destination;
    private String seatType;
    private int pricePerson;
    private LocalDate departureDate;
    private LocalDate returnDate;
}
