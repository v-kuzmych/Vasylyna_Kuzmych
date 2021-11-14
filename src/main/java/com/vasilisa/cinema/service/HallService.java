package com.vasilisa.cinema.service;

import com.vasilisa.cinema.controller.dto.HallDTO;

import java.util.List;

public interface HallService {

    List<HallDTO> getAllHalls();

    HallDTO getHall(int id);

    HallDTO createHall(HallDTO hallDTO);

    HallDTO updateHall(int id, HallDTO hallDTO);

    void deleteHall(int id);
}
