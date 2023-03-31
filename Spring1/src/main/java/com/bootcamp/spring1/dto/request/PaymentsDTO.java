package com.bootcamp.spring1.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PaymentsDTO {
    private String type; // Tipo de tarjeta
    private String number; // Numero tarjeta
    private Integer dues; // Cantidad de cuotas
}
