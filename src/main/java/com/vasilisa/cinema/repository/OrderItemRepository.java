package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
