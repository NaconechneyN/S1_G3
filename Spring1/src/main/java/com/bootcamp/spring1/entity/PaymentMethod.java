package com.bootcamp.spring1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//JPA
@Entity
@Table(name = "metodo_pago")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tipo_tarjeta", nullable = false, length = 10)
    protected String type; // Débito o crédito
    @Column(name = "numero_tarjeta", nullable = false, length = 20)
    protected String number; // Numero tarjeta
    @Column(name = "cuotas", nullable = false, scale = 2)
    protected Integer dues; // Cantidad de cuotas
}
