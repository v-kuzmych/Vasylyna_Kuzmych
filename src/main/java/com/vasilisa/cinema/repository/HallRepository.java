package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

    List<Hall> findAll();

    Optional<Hall> findById(Long id);

    boolean existsById(Long id);

    Hall save(Hall hall);

    void deleteById(Long id);
}
