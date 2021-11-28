package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.ReservationDto;
import com.vasilisa.cinema.mapper.ReservationMapper;
import com.vasilisa.cinema.model.*;
import com.vasilisa.cinema.repository.*;
import com.vasilisa.cinema.service.ReservationService;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeanceRepository seanceRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<ReservationDto> getAllOrders(Pageable pageable) {
        log.info("get all reservations");
        Page<Reservation> pagedResult = reservationRepository.findAll(pageable);

        if (!pagedResult.hasContent()) {
            throw new EntityNotFoundException(format("Orders not found"));
        }

        return ReservationMapper.INSTANCE.mapReservationDtos(pagedResult.getContent());
    }

    @Override
    public ReservationDto getOrder(Long id) {
        log.info("get reservation by id {}", id);
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(format("Reservation with id %s not found", id)));
        return ReservationMapper.INSTANCE.mapReservationDto(reservation);
    }

    @Override
    public ReservationDto createOrder(ReservationDto reservationDto) {
        Reservation reservation = ReservationMapper.INSTANCE.mapReservation(reservationDto);
        Reservation finalReservation = reservation;

        // update free seats in seance
        // the count of seats decreased by the number of purchased tickets
        Seance seance = seanceRepository.findById(reservation.getSeance().getId())
                .orElseThrow(() -> new EntityNotFoundException(format("Seance with id %s not found", finalReservation.getSeance().getId())));
        seance.setFreeSeats(seance.getFreeSeats() - reservation.getOrderItems().size());
        seanceRepository.save(seance);

        reservation.setDate(LocalDateTime.now());

        reservation = reservationRepository.save(reservation);
        log.info("created reservation with id {}", reservation.getId());

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem item : reservationDto.getOrderItems()) {
            item.setReservation(reservation);
            orderItems.add(item);
        }
        orderItemRepository.saveAll(orderItems);
        reservation.setOrderItems(orderItems);

        return ReservationMapper.INSTANCE.mapReservationDto(reservation);
    }

    @Override
    public void deleteOrder(Long id) {
        log.info("delete order with id {}", id);
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException(format("Reservation with id %s not found", id));
        }
        reservationRepository.deleteById(id);
    }
}
