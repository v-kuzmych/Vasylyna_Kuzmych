package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@Builder
public class SeanceDto {

    @Positive
    int id;

    @Positive
    int filmId;

    @Positive
    int hallId;

    @Positive
    int price;

    LocalDateTime date;

    @Min(0)
    int freeSeats;
}
