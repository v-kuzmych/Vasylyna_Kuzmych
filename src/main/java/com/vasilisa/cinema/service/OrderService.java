package com.vasilisa.cinema.service;

import com.vasilisa.cinema.controller.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders();

    OrderDto getOrder(int id);

    OrderDto createOrder(OrderDto orderDTO);

    OrderDto updateOrder(int id, OrderDto orderDTO);

    void deleteOrder(int id);
}
