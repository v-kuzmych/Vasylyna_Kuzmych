package com.vasilisa.cinema.dto;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class OrderItemDto {

    @Positive
    private Long id;

    private OrderDto order;

    @Positive
    private int seatNumber;

    @Positive
    private int rowNumber;
}
