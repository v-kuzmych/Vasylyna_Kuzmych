package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

    List<Seance> findAll();

    Optional<Seance> findById(Long id);

    boolean existsById(Long id);

    Seance save(Seance seance);

    void deleteById(Long id);
}
