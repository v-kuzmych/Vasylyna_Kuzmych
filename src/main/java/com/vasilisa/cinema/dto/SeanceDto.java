package com.vasilisa.cinema.dto;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
public class SeanceDto {

    @Positive
    private Long id;

    private FilmDto film;

    private HallDto hall;

    @Positive
    private int price;

    @FutureOrPresent
    private LocalDateTime date;

    @Min(0)
    private int freeSeats;
}
