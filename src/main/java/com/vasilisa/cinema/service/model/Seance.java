package com.vasilisa.cinema.service.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Seance {
    int id;
    int filmId;
    int hallId;
    int price;
    LocalDateTime date;
    int freeSeats;
}
