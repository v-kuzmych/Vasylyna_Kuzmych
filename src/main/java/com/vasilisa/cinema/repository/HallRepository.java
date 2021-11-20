package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Hall;

import java.util.List;

public interface HallRepository {

    List<Hall> getAllHalls();

    Hall getHall(int id);

    Hall createHall(Hall hall);

    Hall updateHall(int id, Hall hall);

    void deleteHall(int id);
}
