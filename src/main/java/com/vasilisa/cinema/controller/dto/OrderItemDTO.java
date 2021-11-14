package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDTO {
    int id;
    int orderId;
    int seatNumber;
    int rowNumber;
}
