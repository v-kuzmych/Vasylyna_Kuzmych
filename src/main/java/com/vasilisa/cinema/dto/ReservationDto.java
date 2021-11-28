package com.vasilisa.cinema.dto;

import com.vasilisa.cinema.model.OrderItem;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.model.User;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReservationDto {

    @Positive
    private Long id;

    private User user;

    private Seance seance;

    @Positive
    private int price;

    @FutureOrPresent
    private LocalDateTime date;

    private List<OrderItem> orderItems;
}
