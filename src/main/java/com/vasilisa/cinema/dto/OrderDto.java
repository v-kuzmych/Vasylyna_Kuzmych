package com.vasilisa.cinema.dto;

import com.vasilisa.cinema.model.OrderItem;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    @Positive
    private Long id;

    private UserDto user;
    private SeanceDto seance;

    @Positive
    private int price;

    @FutureOrPresent
    private LocalDateTime date;

    @NotEmpty
    private List<OrderItem> orderItems;
}
