package com.vasilisa.cinema.repository.impl;

import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.repository.SeanceRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
                .orElseThrow(() -> new RuntimeException("seance is not find"));
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
            throw new RuntimeException("seance is not found");
        }
        return seance;
    }

    @Override
    public void deleteSeance(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
