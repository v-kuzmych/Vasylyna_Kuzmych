package com.vasilisa.cinema.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Seance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    int price;

    @Column(nullable = false)
    LocalDateTime date;

    @Column(nullable = false)
    int freeSeats;

    @ManyToOne
    @JoinColumn(name="film_id")
    Film film;

    @ManyToOne
    @JoinColumn(name="hall_id")
    Hall hall;
}
