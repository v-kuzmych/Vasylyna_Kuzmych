package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.controller.dto.OrderDTO;
import com.vasilisa.cinema.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders")
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDTO getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    public OrderDTO updateOrder(@PathVariable int id, @RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
