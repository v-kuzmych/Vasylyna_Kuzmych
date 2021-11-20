package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.OrderDTO;
import com.vasilisa.cinema.service.OrderService;
import com.vasilisa.cinema.model.Order;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.OrderRepository;
import com.vasilisa.cinema.repository.SeanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final SeanceRepository seanceRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        log.info("get all orders");
        return orderRepository.getAllOrders()
                .stream()
                .map(this::mapOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrder(int id) {
        log.info("get order by id {}", id);
        Order order = orderRepository.getOrder(id);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info("create order with id {}", orderDTO.getId());
        Order order = mapOrderDtoToOrder(orderDTO);
        order = orderRepository.createOrder(order);

        // update free seats in seance
        // the count of seats decreased by the number of purchased tickets
        Seance seance = seanceRepository.getSeance(order.getSeanceId());
        seance.setFreeSeats(seance.getFreeSeats() - order.getOrderItems().size());
        seanceRepository.updateSeance(seance.getId(), seance);

        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDTO updateOrder(int id, OrderDTO orderDTO) {
        log.info("update order with id {}", id);
        Order order = mapOrderDtoToOrder(orderDTO);
        order = orderRepository.updateOrder(id, order);
        return mapOrderToOrderDto(order);
    }

    @Override
    public void deleteOrder(int id) {
        log.info("delete order with id {}", id);
        orderRepository.deleteOrder(id);
    }

    private OrderDTO mapOrderToOrderDto(Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .seanceId(order.getSeanceId())
                .price(order.getPrice())
                .date(order.getDate())
                .orderItems(order.getOrderItems())
                .build();
    }

    private Order mapOrderDtoToOrder(OrderDTO orderDTO){
        return Order.builder()
                .id(orderDTO.getId())
                .userId(orderDTO.getUserId())
                .seanceId(orderDTO.getSeanceId())
                .price(orderDTO.getPrice())
                .date(orderDTO.getDate())
                .orderItems(orderDTO.getOrderItems())
                .build();
    }
}
