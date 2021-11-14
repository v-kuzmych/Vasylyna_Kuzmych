package com.vasilisa.cinema.controller.dto;

import com.vasilisa.cinema.service.model.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    int id;
    int userId;
    int seanceId;
    int price;
    LocalDateTime date;
    List<OrderItem> orderItems;
}
