package com.bootcamp.spring1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

//Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//JPA
@Entity
@Table(name = "cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 40)
    private String name;
    @Column(name = "apellido", nullable = false, length = 40)
    private String lastName;
    @Column(name = "documento", nullable = false, length = 8)
    private String dni;
    @Column(length = 100)
    private String email;
    @Column(name = "fechaNacimiento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    @Column(name = "método_pago", nullable = false)
    protected String PaymentMethod;
}
