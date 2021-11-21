package com.vasilisa.cinema.repository.impl;

import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.SeanceRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Component
public class SeanceRepositoryImpl implements SeanceRepository {

    private final List<Seance> list = new ArrayList<>();

    @Override
    public List<Seance> getAllSeances() {
        return new ArrayList<>(list);
    }

    @Override
    public Seance getSeance(int id) {
        return list.stream()
                .filter(seance -> seance.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Seance createSeance(Seance seance) {
        list.add(seance);
        return seance;
    }

    @Override
    public Seance updateSeance(int id, Seance seance) {
        boolean isDeleted = list.removeIf(u -> u.getId() == id);
        if (isDeleted){
            list.add(seance);
        } else {
            throw new EntityNotFoundException(format("Seance with id %s not found", id));
        }
        return seance;
    }

    @Override
    public void deleteSeance(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
