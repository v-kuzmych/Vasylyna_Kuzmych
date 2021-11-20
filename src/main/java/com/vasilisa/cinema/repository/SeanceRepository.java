package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Seance;

import java.util.List;

public interface SeanceRepository {

    List<Seance> getAllSeances();

    Seance getSeance(int id);

    Seance createSeance(Seance seance);

    Seance updateSeance(int id, Seance seance);

    void deleteSeance(int id);
}
