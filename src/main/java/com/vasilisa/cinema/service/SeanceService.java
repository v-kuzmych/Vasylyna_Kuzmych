package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.SeanceDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SeanceService {

    List<SeanceDto> getAllSeances(Pageable pageable);

    SeanceDto getSeance(Long id);

    SeanceDto createSeance(SeanceDto seanceDTO);

    SeanceDto updateSeance(SeanceDto seanceDTO);

    void deleteSeance(Long id);
}
