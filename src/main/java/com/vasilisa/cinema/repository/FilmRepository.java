package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findAll();

    Optional<Film> findById(Long id);

    boolean existsById(Long id);

    Film save(Film film);

    void deleteById(Long id);
}
