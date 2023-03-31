package com.bootcamp.spring1.dto.request.hotel;

import com.bootcamp.spring1.dto.request.ClienteDTO;
import com.bootcamp.spring1.dto.request.PaymentsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingDTO {
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateTo;
    private String city;
    private String hotelCode;
    @NotNull
    @Positive(message = "La cantidad de personas debe ser un valor numérico.")
    private Integer peopleAmount;
    private String roomType;
    private List<@Valid ClienteDTO> people;
    private PaymentsDTO Payments;


}
