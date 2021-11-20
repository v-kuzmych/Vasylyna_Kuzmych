package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> getAllOrders();

    Order getOrder(int id);

    Order createOrder(Order order);

    Order updateOrder(int id, Order order);

    void deleteOrder(int id);
}
