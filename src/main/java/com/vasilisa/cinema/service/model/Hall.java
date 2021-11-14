package com.vasilisa.cinema.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hall {
    int id;
    int numberOfRows;
    int numberOfSeats;
}
