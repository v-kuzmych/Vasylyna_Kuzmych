package com.vasilisa.cinema.mapper;

import com.vasilisa.cinema.dto.ReservationDto;
import com.vasilisa.cinema.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    List<ReservationDto> mapReservationDtos(List<Reservation> reservations);

    ReservationDto mapReservationDto(Reservation reservation);

    Reservation mapReservation(ReservationDto reservationDto);
}
