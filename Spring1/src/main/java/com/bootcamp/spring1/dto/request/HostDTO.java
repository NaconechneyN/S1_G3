package com.bootcamp.spring1.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated

public class HostDTO {
    private Integer dni;
    private String firstName;
    private String lastname;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthday;
    @NotEmpty @Email //Validación de que se envíe mail con formato nombre@servidor.com
    private String mail;
}
