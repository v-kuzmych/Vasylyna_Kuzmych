package com.vasilisa.cinema.service.repository;

import com.vasilisa.cinema.service.model.Hall;

import java.util.List;

public interface HallRepository {

    List<Hall> getAllHalls();

    Hall getHall(int id);

    Hall createHall(Hall hall);

    Hall updateHall(int id, Hall hall);

    void deleteHall(int id);
}
