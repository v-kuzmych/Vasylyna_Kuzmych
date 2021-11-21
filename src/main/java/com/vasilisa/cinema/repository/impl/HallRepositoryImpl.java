package com.vasilisa.cinema.repository.impl;

import com.vasilisa.cinema.model.Hall;
import com.vasilisa.cinema.repository.HallRepository;
import com.vasilisa.cinema.service.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Component
public class HallRepositoryImpl implements HallRepository {

    private final List<Hall> list = new ArrayList<>();

    @Override
    public List<Hall> getAllHalls() {
        return new ArrayList<>(list);
    }

    @Override
    public Hall getHall(int id) {
        return list.stream()
                .filter(hall -> hall.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Hall createHall(Hall hall) {
        list.add(hall);
        return hall;
    }

    @Override
    public Hall updateHall(int id, Hall hall) {
        boolean isDeleted = list.removeIf(u -> u.getId() == id);
        if (isDeleted){
            list.add(hall);
        } else {
            throw new EntityNotFoundException(format("Hall with id %s not found", id));
        }
        return hall;
    }

    @Override
    public void deleteHall(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
