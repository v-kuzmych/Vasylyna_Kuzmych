package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.OrderDto;
import com.vasilisa.cinema.service.OrderService;
import com.vasilisa.cinema.model.Order;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.OrderRepository;
import com.vasilisa.cinema.repository.SeanceRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final SeanceRepository seanceRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        log.info("get all orders");
        return OrderMapper.INSTANCE.mapOrderDtos(orderRepository.getAllOrders());
    }

    @Override
    public OrderDto getOrder(int id) {
        log.info("get order by id {}", id);
        Order order = orderRepository.getOrder(id);
        if (order == null) {
            throw new EntityNotFoundException(format("Order with id %s not found", id));
        }
        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("create order with id {}", orderDto.getId());
        Order order = OrderMapper.INSTANCE.mapOrder(orderDto);
        order = orderRepository.createOrder(order);

        // update free seats in seance
        // the count of seats decreased by the number of purchased tickets
        Seance seance = seanceRepository.getSeance(order.getSeanceId());
        seance.setFreeSeats(seance.getFreeSeats() - order.getOrderItems().size());
        seanceRepository.updateSeance(seance.getId(), seance);

        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(int id, OrderDto orderDto) {
        log.info("update order with id {}", id);
        Order order = OrderMapper.INSTANCE.mapOrder(orderDto);
        order = orderRepository.updateOrder(id, order);
        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public void deleteOrder(int id) {
        log.info("delete order with id {}", id);
        orderRepository.deleteOrder(id);
    }
}
