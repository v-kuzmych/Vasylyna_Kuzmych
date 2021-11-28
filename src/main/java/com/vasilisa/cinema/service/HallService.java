package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.HallDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HallService {

    List<HallDto> getAllHalls(Pageable pageable);

    HallDto getHall(Long id);

    HallDto createHall(HallDto hallDTO);

    void deleteHall(Long id);
}
