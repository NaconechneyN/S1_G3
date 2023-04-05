package com.bootcamp.spring1.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelDTO {
    private Integer id;
    private String hotelCode;
    private String name;
    private String city;
    private String roomType;
    private Double price;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateTo;
    private Boolean booked;
    private Boolean petFriendly;
}

