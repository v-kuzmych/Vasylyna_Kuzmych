package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Reservation;
import com.vasilisa.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAll();

    Optional<Reservation> findById(Long id);

    Reservation save(Reservation reservation);

    boolean existsById(Long id);

    void deleteById(Long id);
}
