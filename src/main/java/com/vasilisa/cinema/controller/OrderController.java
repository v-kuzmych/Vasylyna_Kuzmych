package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.dto.OrderDto;
import com.vasilisa.cinema.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders")
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDto getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDto createOrder(@Valid @RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    public OrderDto updateOrder(@PathVariable int id, @RequestBody @Valid OrderDto orderDto){
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
