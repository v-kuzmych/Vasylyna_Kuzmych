package com.vasilisa.cinema.service.repository.impl;

import com.vasilisa.cinema.service.model.Hall;
import com.vasilisa.cinema.service.repository.HallRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
                .orElseThrow(() -> new RuntimeException("hall is not find"));
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
            throw new RuntimeException("hall is not found");
        }
        return hall;
    }

    @Override
    public void deleteHall(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
