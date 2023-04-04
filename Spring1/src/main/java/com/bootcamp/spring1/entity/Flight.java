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
@Table(name = "vuelos")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_vuelo", nullable = false, length = 15)
    private String flightNumber;
    @Column(name = "ciudad_origen", nullable = false, length = 60)
    private String origin;
    @Column(name = "ciudad_destino", nullable = false, length = 60)
    private String destination;
    @Column(name = "tipo_asiento", nullable = false, length = 20)
    private String seatType;
    @Column(name = "precio", nullable = false, scale = 4)
    private Integer flightPrice;
    @Column(name = "fecha_salida", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFrom;
    @Column(name = "fecha_retorno", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateTo;
    @Column(name = "reserva")
    private Boolean reservation = false;

}

