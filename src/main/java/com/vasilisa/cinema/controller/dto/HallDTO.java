package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HallDTO {
    int id;
    int numberOfRows;
    int numberOfSeats;
}
