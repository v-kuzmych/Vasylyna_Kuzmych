package com.vasilisa.cinema.dto;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class HallDto {

    @Positive
    private Long id;

    @Positive
    private int numberOfRows;

    @Positive
    private int numberOfSeats;
}
