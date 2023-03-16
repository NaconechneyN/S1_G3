package com.bootcamp.spring1.dto.request.hotel;

import com.bootcamp.spring1.dto.request.HostDTO;
import com.bootcamp.spring1.dto.request.PaymentsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Validated
public class BookingDTO {
   @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateTo;
    private String destination;
    private String hotelCode;
     @NotEmpty @Positive(message = "La cantidad de personas debe ser un valor numérico.")
    private Integer peopleAmount;
    private String roomType;

    private PaymentsDTO Payments;
    private List<HostDTO> people;

}
