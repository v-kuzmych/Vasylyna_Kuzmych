package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.dto.ReservationDto;
import com.vasilisa.cinema.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/reservations")
    public List<ReservationDto> getAllOrders(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return reservationService.getAllOrders(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public ReservationDto getOrder(@PathVariable Long id){
        return reservationService.getOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public ReservationDto createOrder(@Valid @RequestBody ReservationDto reservationDto){
        return reservationService.createOrder(reservationDto);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        reservationService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
