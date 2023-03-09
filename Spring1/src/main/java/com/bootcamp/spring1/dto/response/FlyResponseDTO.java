package com.bootcamp.spring1.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlyResponseDTO {
    private String mensaje = "El monto total del vuelo es de: ";
    private Integer total;
}
