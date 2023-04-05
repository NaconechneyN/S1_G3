package com.bootcamp.spring1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
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
//JPA
@Entity
@Table(name = "reserva_vuelo")
public class BookingFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario", nullable = false,length = 50)
    private String username;

    @Column(name = "fecha_salida", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate dateFrom;

    @Column(name = "fecha_retorno", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate dateTo;
    @Column(name = "ciudad_origen", nullable = false, length = 60)
    private String origin;
    @Column(name = "ciudad_destino", nullable = false, length = 60)
    private String destination;
    @Column(name = "numero_vuelo", nullable = false, length = 15)
    private String flightNumber;
    @Positive(message = "La cantidad de personas debe ser un valor numérico mayor a 0")
    @Column(name = "cantidad_asiento", nullable = false, length = 20)
    private Integer seats;
    @Column(name = "tipo_asiento", nullable = false, length = 20)
    private String seatType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> people;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentMethod payments;

}

