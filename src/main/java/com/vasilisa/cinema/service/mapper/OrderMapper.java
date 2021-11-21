package com.vasilisa.cinema.service.mapper;

import com.vasilisa.cinema.controller.dto.OrderDto;
import com.vasilisa.cinema.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<OrderDto> mapOrderDtos(List<Order> orders);

    OrderDto mapOrderDto(Order order);

    Order mapOrder(OrderDto orderDto);
}
