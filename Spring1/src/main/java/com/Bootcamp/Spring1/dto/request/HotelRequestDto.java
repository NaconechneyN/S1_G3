package com.Bootcamp.Spring1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class HotelRequestDto {

    // datos que va a enviar en respuesta
    private String name;
    private String city;

}
