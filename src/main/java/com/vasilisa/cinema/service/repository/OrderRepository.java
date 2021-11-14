package com.vasilisa.cinema.service.repository;

import com.vasilisa.cinema.service.model.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> getAllOrders();

    Order getOrder(int id);

    Order createOrder(Order order);

    Order updateOrder(int id, Order order);

    void deleteOrder(int id);
}
