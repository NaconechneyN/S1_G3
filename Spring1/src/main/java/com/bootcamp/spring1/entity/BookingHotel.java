package com.bootcamp.spring1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

//Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//JPA
@Entity
@Table(name = "reserva_hotel")
public class BookingHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "usuario", nullable = false,length = 20)
    private String username;
    @Column(name = "fecha_entrada", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateFrom;
    @Column(name = "fecha_salida", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateTo;
    @Column(name = "ciudad_destino", nullable = false, length = 60)
    private String city;
    @Column(name = "codigo_hotel", nullable = false, length = 15)
    private String hotelCode;
    @Column(name = "cantidad_personas", nullable = false, scale = 2)
    @NotNull
    @Positive(message = "La cantidad de personas debe ser un valor numérico.")
    private Integer peopleAmount;
    @Column(name = "tipo_habitacion", nullable = false, length = 20)
    private String roomType;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> people;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentMethod payments;
}
