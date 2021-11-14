package com.vasilisa.cinema.service.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Order {
    int id;
    int userId;
    int seanceId;
    int price;
    LocalDateTime date;
    List<OrderItem> orderItems;
}
