package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.ReservationDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {

    List<ReservationDto> getAllOrders(Pageable pageable);

    ReservationDto getOrder(Long id);

    ReservationDto createOrder(ReservationDto reservationDTO);

    void deleteOrder(Long id);
}
