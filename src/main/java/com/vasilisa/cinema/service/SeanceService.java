package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.SeanceDto;

import java.util.List;

public interface SeanceService {

    List<SeanceDto> getAllSeances();

    SeanceDto getSeance(int id);

    SeanceDto createSeance(SeanceDto seanceDTO);

    SeanceDto updateSeance(int id, SeanceDto seanceDTO);

    void deleteSeance(int id);
}
