package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SeanceDTO {
    int id;
    int filmId;
    int hallId;
    int price;
    LocalDateTime date;
    int freeSeats;
}
