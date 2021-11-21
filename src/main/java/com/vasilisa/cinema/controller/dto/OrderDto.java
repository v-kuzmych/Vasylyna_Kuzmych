package com.vasilisa.cinema.controller.dto;

import com.vasilisa.cinema.model.OrderItem;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDto {

    @Positive
    int id;

    @Positive
    int userId;

    @Positive
    int seanceId;

    @Positive
    int price;

    @FutureOrPresent
    LocalDateTime date;

    @NotEmpty
    List<OrderItem> orderItems;
}
