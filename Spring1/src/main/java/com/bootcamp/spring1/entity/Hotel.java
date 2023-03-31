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
@Table()
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "código_hotel", nullable = false, length = 15, unique = true)
    private String hotelCode;
    @Column(name = "nombre_hotel", nullable = false, length = 40)
    private String name;
    @Column(name = "ciudad", nullable = false, length = 60)
    private String city;
    @Column(name = "tipo_habitación", nullable = false, length = 20)
    private String roomType;
    @Column(name = "precio", scale = 4, precision = 2)
    private Double price;
    @Column(name = "fecha_disponibilidad_desde", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateFrom;
    @Column(name = "fecha_disponibilidad_hasta", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateTo;
    @Column(name = "reservado", nullable = false)
    private Boolean booked;
    @OneToOne
    private BookingHotel booking;

}

