package com.vasilisa.cinema.repository.impl;

import com.vasilisa.cinema.model.Order;
import com.vasilisa.cinema.repository.OrderRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> list = new ArrayList<>();

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(list);
    }

    @Override
    public Order getOrder(int id) {
        return list.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        order.setDate(LocalDateTime.now());
        list.add(order);
        return order;
    }

    @Override
    public Order updateOrder(int id, Order order) {
        boolean isDeleted = list.removeIf(u -> u.getId() == id);
        if (isDeleted){
            list.add(order);
        } else {
            throw new EntityNotFoundException(format("Order with id %s not found", id));
        }
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
