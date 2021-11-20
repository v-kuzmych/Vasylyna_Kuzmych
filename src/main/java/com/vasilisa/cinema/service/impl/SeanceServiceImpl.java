package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.SeanceDTO;
import com.vasilisa.cinema.service.SeanceService;
import com.vasilisa.cinema.model.Hall;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.HallRepository;
import com.vasilisa.cinema.repository.SeanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;
    private final HallRepository hallRepository;

    @Override
    public List<SeanceDTO> getAllSeances() {
        log.info("get all seances");
        return seanceRepository.getAllSeances()
                .stream()
                .map(this::mapSeanceToSeanceDto)
                .collect(Collectors.toList());
    }

    @Override
    public SeanceDTO getSeance(int id) {
        log.info("get seance by id {}", id);
        Seance seance = seanceRepository.getSeance(id);
        return mapSeanceToSeanceDto(seance);
    }

    @Override
    public SeanceDTO createSeance(SeanceDTO seanceDTO) {
        log.info("create seance with id {}", seanceDTO.getId());
        Seance seance = mapSeanceDtoToSeance(seanceDTO);

        // found count of all seats on seance
        Hall hall = hallRepository.getHall(seance.getHallId());
        seance.setFreeSeats(hall.getNumberOfSeats() * hall.getNumberOfRows());

        seance = seanceRepository.createSeance(seance);
        return mapSeanceToSeanceDto(seance);
    }

    @Override
    public SeanceDTO updateSeance(int id, SeanceDTO seanceDTO) {
        log.info("update seance with id {}", id);
        Seance seance = mapSeanceDtoToSeance(seanceDTO);
        seance = seanceRepository.updateSeance(id, seance);
        return mapSeanceToSeanceDto(seance);
    }

    @Override
    public void deleteSeance(int id) {
        log.info("delete seance with id {}", id);
        seanceRepository.deleteSeance(id);
    }

    private SeanceDTO mapSeanceToSeanceDto(Seance seance){
        return SeanceDTO.builder()
                .id(seance.getId())
                .filmId(seance.getFilmId())
                .hallId(seance.getHallId())
                .date(seance.getDate())
                .price(seance.getPrice())
                .freeSeats(seance.getFreeSeats())
                .build();
    }

    private Seance mapSeanceDtoToSeance(SeanceDTO seanceDTO){
        return Seance.builder()
                .id(seanceDTO.getId())
                .filmId(seanceDTO.getFilmId())
                .hallId(seanceDTO.getHallId())
                .date(seanceDTO.getDate())
                .price(seanceDTO.getPrice())
                .freeSeats(seanceDTO.getFreeSeats())
                .build();
    }
}
