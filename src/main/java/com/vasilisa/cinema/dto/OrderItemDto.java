package com.vasilisa.cinema.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
@Builder
public class OrderItemDto {

    @Positive
    int id;

    @Positive
    int orderId;

    @Positive
    int seatNumber;

    @Positive
    int rowNumber;
}
