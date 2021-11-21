package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.HallDto;
import com.vasilisa.cinema.model.Hall;
import com.vasilisa.cinema.service.HallService;
import com.vasilisa.cinema.repository.HallRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.mapper.HallMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    @Override
    public List<HallDto> getAllHalls() {
        log.info("get all halls");
        return HallMapper.INSTANCE.mapHallDtos(hallRepository.getAllHalls());
    }

    @Override
    public HallDto getHall(int id) {
        log.info("get hall by id {}", id);
        Hall hall = hallRepository.getHall(id);
        if (hall == null) {
            throw new EntityNotFoundException(format("Hall with id %s not found", id));
        }
        return HallMapper.INSTANCE.mapHallDto(hall);
    }

    @Override
    public HallDto createHall(HallDto hallDto) {
        log.info("create hall with id {}", hallDto.getId());
        Hall hall = HallMapper.INSTANCE.mapHall(hallDto);
        hall = hallRepository.createHall(hall);
        return HallMapper.INSTANCE.mapHallDto(hall);
    }

    @Override
    public HallDto updateHall(int id, HallDto hallDto) {
        log.info("update hall with id {}", id);
        Hall hall = HallMapper.INSTANCE.mapHall(hallDto);
        hall = hallRepository.updateHall(id, hall);
        return HallMapper.INSTANCE.mapHallDto(hall);
    }

    @Override
    public void deleteHall(int id) {
        log.info("delete hall with id {}", id);
        hallRepository.deleteHall(id);
    }
}
