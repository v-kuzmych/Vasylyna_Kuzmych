package com.vasilisa.cinema.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    Order order;

    @Column(nullable = false)
    int seatNumber;

    @Column(nullable = false)
    int rowNumber;
}
