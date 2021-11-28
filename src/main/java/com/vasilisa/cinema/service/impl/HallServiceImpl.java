package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.HallDto;
import com.vasilisa.cinema.model.Hall;
import com.vasilisa.cinema.service.HallService;
import com.vasilisa.cinema.repository.HallRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.mapper.HallMapper;
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
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    @Override
    public List<HallDto> getAllHalls(Pageable pageable) {
        log.info("get all halls");
        Page<Hall> pagedResult = hallRepository.findAll(pageable);

        if (!pagedResult.hasContent()) {
            throw new EntityNotFoundException(format("Halls not found"));
        }

        return HallMapper.INSTANCE.mapHallDtos(pagedResult.getContent());
    }

    @Override
    public HallDto getHall(Long id) {
        log.info("get hall by id {}", id);
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(format("Hall with id %s not found", id)));
        return HallMapper.INSTANCE.mapHallDto(hall);
    }

    @Override
    public HallDto createHall(HallDto hallDto) {
        Hall hall = HallMapper.INSTANCE.mapHall(hallDto);
        hall = hallRepository.save(hall);
        log.info("created hall with id {}", hall.getId());
        return HallMapper.INSTANCE.mapHallDto(hall);
    }

    @Override
    public void deleteHall(Long id) {
        log.info("delete hall with id {}", id);
        if (!hallRepository.existsById(id)){
            throw new EntityNotFoundException(format("Hall with id %s not found", id));
        }
        hallRepository.deleteById(id);
    }
}
