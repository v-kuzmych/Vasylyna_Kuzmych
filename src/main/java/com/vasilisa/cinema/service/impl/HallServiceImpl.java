package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.HallDTO;
import com.vasilisa.cinema.service.model.Hall;
import com.vasilisa.cinema.service.HallService;
import com.vasilisa.cinema.service.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    @Override
    public List<HallDTO> getAllHalls() {
        log.info("get all halls");
        return hallRepository.getAllHalls()
                .stream()
                .map(this::mapHallToHallDto)
                .collect(Collectors.toList());
    }

    @Override
    public HallDTO getHall(int id) {
        log.info("get hall by id {}", id);
        Hall hall = hallRepository.getHall(id);
        return mapHallToHallDto(hall);
    }

    @Override
    public HallDTO createHall(HallDTO hallDTO) {
        log.info("create hall with id {}", hallDTO.getId());
        Hall hall = mapHallDtoToHall(hallDTO);
        hall = hallRepository.createHall(hall);
        return mapHallToHallDto(hall);
    }

    @Override
    public HallDTO updateHall(int id, HallDTO hallDTO) {
        log.info("update hall with id {}", id);
        Hall hall = mapHallDtoToHall(hallDTO);
        hall = hallRepository.updateHall(id, hall);
        return mapHallToHallDto(hall);
    }

    @Override
    public void deleteHall(int id) {
        log.info("delete hall with id {}", id);
        hallRepository.deleteHall(id);
    }

    private HallDTO mapHallToHallDto(Hall hall){
        return HallDTO.builder()
                .id(hall.getId())
                .numberOfRows(hall.getNumberOfRows())
                .numberOfSeats(hall.getNumberOfSeats())
                .build();
    }

    private Hall mapHallDtoToHall(HallDTO hallDTO){
        return Hall.builder()
                .id(hallDTO.getId())
                .numberOfRows(hallDTO.getNumberOfRows())
                .numberOfSeats(hallDTO.getNumberOfSeats())
                .build();
    }
}
