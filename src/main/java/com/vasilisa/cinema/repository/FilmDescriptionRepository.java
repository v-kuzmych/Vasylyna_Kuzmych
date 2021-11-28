package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.FilmDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmDescriptionRepository extends JpaRepository<FilmDescription, Long> {

}
