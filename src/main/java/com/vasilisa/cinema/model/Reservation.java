package com.vasilisa.cinema.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    int price;

    @Column(nullable = false)
    LocalDateTime date;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "reservation")
    List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name="seance_id")
    Seance seance;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;
}
