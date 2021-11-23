package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.OrderDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrders(Pageable pageable);

    OrderDto getOrder(Long id);

    OrderDto createOrder(OrderDto orderDTO);

    OrderDto updateOrder(OrderDto orderDTO);

    void deleteOrder(Long id);
}
