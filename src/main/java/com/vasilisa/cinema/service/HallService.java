package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.HallDto;

import java.util.List;

public interface HallService {

    List<HallDto> getAllHalls();

    HallDto getHall(int id);

    HallDto createHall(HallDto hallDTO);

    HallDto updateHall(int id, HallDto hallDTO);

    void deleteHall(int id);
}
