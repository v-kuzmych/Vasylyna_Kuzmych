package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.OrderDto;
import com.vasilisa.cinema.mapper.HallMapper;
import com.vasilisa.cinema.model.Hall;
import com.vasilisa.cinema.service.OrderService;
import com.vasilisa.cinema.model.Order;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.OrderRepository;
import com.vasilisa.cinema.repository.SeanceRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<OrderDto> getAllOrders(Pageable pageable) {
        log.info("get all orders");
        Page<Order> pagedResult = orderRepository.findAll(pageable);

        if (!pagedResult.hasContent()) {
            throw new EntityNotFoundException(format("Orders not found"));
        }

        return OrderMapper.INSTANCE.mapOrderDtos(pagedResult.getContent());
    }

    @Override
    public OrderDto getOrder(Long id) {
        log.info("get order by id {}", id);
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(format("Order with id %s not found", id)));
        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("create order with id {}", orderDto.getId());
        Order order = OrderMapper.INSTANCE.mapOrder(orderDto);
        order = orderRepository.save(order);

        // update free seats in seance
        // the count of seats decreased by the number of purchased tickets
        Order finalOrder = order;
        Seance seance = seanceRepository.findById(order.getSeance().getId()).orElseThrow(() -> new EntityNotFoundException(format("Seance with id %s not found", finalOrder.getSeance().getId())));
        seance.setFreeSeats(seance.getFreeSeats() - order.getOrderItems().size());
        seanceRepository.save(seance);

        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Long id = orderDto.getId();
        log.info("update order with id {}", id);
        if (!orderRepository.existsById(id)){
            throw new EntityNotFoundException(format("Order with id %s not found", id));
        }
        Order order = OrderMapper.INSTANCE.mapOrder(orderDto);
        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.mapOrderDto(order);
    }

    @Override
    public void deleteOrder(Long id) {
        log.info("delete order with id {}", id);
        if (!orderRepository.existsById(id)){
            throw new EntityNotFoundException(format("Order with id %s not found", id));
        }
        orderRepository.deleteById(id);
    }
}
