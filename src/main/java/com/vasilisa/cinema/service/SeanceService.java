package com.vasilisa.cinema.service;

import com.vasilisa.cinema.controller.dto.SeanceDTO;

import java.util.List;

public interface SeanceService {

    List<SeanceDTO> getAllSeances();

    SeanceDTO getSeance(int id);

    SeanceDTO createSeance(SeanceDTO seanceDTO);

    SeanceDTO updateSeance(int id, SeanceDTO seanceDTO);

    void deleteSeance(int id);
}
