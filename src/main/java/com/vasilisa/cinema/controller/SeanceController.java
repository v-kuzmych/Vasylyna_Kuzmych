package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.dto.SeanceDto;
import com.vasilisa.cinema.service.SeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SeanceController {

    private final SeanceService seanceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/seances")
    public List<SeanceDto> getAllSeances(){
        return seanceService.getAllSeances();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/seance/{id}")
    public SeanceDto getSeance(@PathVariable int id){
        return seanceService.getSeance(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/seance")
    public SeanceDto createSeance(@Valid @RequestBody SeanceDto seanceDto){
        return seanceService.createSeance(seanceDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/seance/{id}")
    public SeanceDto updateSeance(@PathVariable int id, @RequestBody @Valid SeanceDto seanceDto){
        return seanceService.updateSeance(id, seanceDto);
    }

    @DeleteMapping(value = "/seance/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable int id){
        seanceService.deleteSeance(id);
        return ResponseEntity.noContent().build();
    }
}
