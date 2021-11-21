package com.vasilisa.cinema.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
@Builder
public class HallDto {

    @Positive
    int id;

    @Positive
    int numberOfRows;

    @Positive
    int numberOfSeats;
}
