package com.vasilisa.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reservation_id")
    Reservation reservation;

    @Column(nullable = false)
    int seatNumber;

    @Column(nullable = false)
    int lineNumber;
}
