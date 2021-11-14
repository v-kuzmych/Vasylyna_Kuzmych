package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.controller.dto.SeanceDTO;
import com.vasilisa.cinema.service.SeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SeanceController {

    private final SeanceService seanceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/seances")
    public List<SeanceDTO> getAllSeances(){
        return seanceService.getAllSeances();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/seance/{id}")
    public SeanceDTO getSeance(@PathVariable int id){
        return seanceService.getSeance(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/seance")
    public SeanceDTO createSeance(@RequestBody SeanceDTO seanceDTO){
        return seanceService.createSeance(seanceDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/seance/{id}")
    public SeanceDTO updateSeance(@PathVariable int id, @RequestBody SeanceDTO seanceDTO){
        return seanceService.updateSeance(id, seanceDTO);
    }

    @DeleteMapping(value = "/seance/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable int id){
        seanceService.deleteSeance(id);
        return ResponseEntity.noContent().build();
    }
}
