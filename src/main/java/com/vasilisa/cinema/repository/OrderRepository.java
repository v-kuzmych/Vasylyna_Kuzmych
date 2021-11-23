package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();

    Optional<Order> findById(Long id);

    boolean existsById(Long id);

    Order save(Order order);

    void deleteById(Long id);
}
