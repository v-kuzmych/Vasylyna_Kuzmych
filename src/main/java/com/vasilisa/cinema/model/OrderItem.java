package com.vasilisa.cinema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {
    int id;
    int orderId;
    int seatNumber;
    int rowNumber;
}
