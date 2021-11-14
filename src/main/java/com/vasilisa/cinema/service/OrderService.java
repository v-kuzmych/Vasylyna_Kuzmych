package com.vasilisa.cinema.service;

import com.vasilisa.cinema.controller.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO getOrder(int id);

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(int id, OrderDTO orderDTO);

    void deleteOrder(int id);
}
