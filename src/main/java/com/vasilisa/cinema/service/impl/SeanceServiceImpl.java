package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.SeanceDto;
import com.vasilisa.cinema.service.SeanceService;
import com.vasilisa.cinema.model.Hall;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.HallRepository;
import com.vasilisa.cinema.repository.SeanceRepository;
import com.vasilisa.cinema.service.exception.EntityNotFoundException;
import com.vasilisa.cinema.service.mapper.SeanceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;
    private final HallRepository hallRepository;

    @Override
    public List<SeanceDto> getAllSeances() {
        log.info("get all seances");
        return SeanceMapper.INSTANCE.mapSeanceDtos(seanceRepository.getAllSeances());
    }

    @Override
    public SeanceDto getSeance(int id) {
        log.info("get seance by id {}", id);
        Seance seance = seanceRepository.getSeance(id);
        if (seance == null) {
            throw new EntityNotFoundException(format("Seance with id %s not found", id));
        }
        return SeanceMapper.INSTANCE.mapSeanceDto(seance);
    }

    @Override
    public SeanceDto createSeance(SeanceDto seanceDto) {
        log.info("create seance with id {}", seanceDto.getId());
        Seance seance = SeanceMapper.INSTANCE.mapSeance(seanceDto);

        // found count of all seats on seance
        Hall hall = hallRepository.getHall(seance.getHallId());
        seance.setFreeSeats(hall.getNumberOfSeats() * hall.getNumberOfRows());

        seance = seanceRepository.createSeance(seance);
        return SeanceMapper.INSTANCE.mapSeanceDto(seance);
    }

    @Override
    public SeanceDto updateSeance(int id, SeanceDto seanceDto) {
        log.info("update seance with id {}", id);
        Seance seance = SeanceMapper.INSTANCE.mapSeance(seanceDto);
        seance = seanceRepository.updateSeance(id, seance);
        return SeanceMapper.INSTANCE.mapSeanceDto(seance);
    }

    @Override
    public void deleteSeance(int id) {
        log.info("delete seance with id {}", id);
        seanceRepository.deleteSeance(id);
    }
}
