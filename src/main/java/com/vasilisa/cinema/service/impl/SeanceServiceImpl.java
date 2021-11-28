package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.SeanceDto;
import com.vasilisa.cinema.service.SeanceService;
import com.vasilisa.cinema.model.Hall;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.HallRepository;
import com.vasilisa.cinema.repository.SeanceRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.mapper.SeanceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<SeanceDto> getAllSeances(Pageable pageable) {
        log.info("get all seances");
        Page<Seance> pagedResult = seanceRepository.findAll(pageable);

        if (!pagedResult.hasContent()) {
            throw new EntityNotFoundException(format("Seances not found"));
        }

        return SeanceMapper.INSTANCE.mapSeanceDtos(pagedResult.getContent());
    }

    @Override
    public SeanceDto getSeance(Long id) {
        log.info("get seance by id {}", id);
        Seance seance = seanceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(format("Seance with id %s not found", id)));
        return SeanceMapper.INSTANCE.mapSeanceDto(seance);
    }

    @Override
    public SeanceDto createSeance(SeanceDto seanceDto) {
        Seance seance = SeanceMapper.INSTANCE.mapSeance(seanceDto);

        // found count of all seats on seance
        Hall hall = hallRepository.findById(seanceDto.getHall().getId()).orElseThrow(() -> new EntityNotFoundException(format("Seance with id %s not found", seanceDto.getHall().getId())));
        seance.setFreeSeats(hall.getNumberOfSeats() * hall.getNumberOfRows());

        seance = seanceRepository.save(seance);
        log.info("created seance with id {}", seance.getId());

        return SeanceMapper.INSTANCE.mapSeanceDto(seance);
    }

    @Override
    public SeanceDto updateSeance(SeanceDto seanceDto) {
        Long id = seanceDto.getId();
        log.info("update seance with id {}", id);
        if (!seanceRepository.existsById(id)){
            throw new EntityNotFoundException(format("Seance with id %s not found", id));
        }
        Seance seance = SeanceMapper.INSTANCE.mapSeance(seanceDto);
        seance = seanceRepository.save(seance);
        return SeanceMapper.INSTANCE.mapSeanceDto(seance);
    }

    @Override
    public void deleteSeance(Long id) {
        log.info("delete seance with id {}", id);
        if (!seanceRepository.existsById(id)){
            throw new EntityNotFoundException(format("Seance with id %s not found", id));
        }
        seanceRepository.deleteById(id);
    }
}
