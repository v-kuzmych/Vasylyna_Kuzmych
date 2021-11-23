package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.dto.SeanceDto;
import com.vasilisa.cinema.model.Seance;
import com.vasilisa.cinema.service.SeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<SeanceDto> getAllSeances(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return seanceService.getAllSeances(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/seance/{id}")
    public SeanceDto getSeance(@PathVariable Long id){
        return seanceService.getSeance(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/seance")
    public SeanceDto createSeance(@Valid @RequestBody SeanceDto seanceDto){
        return seanceService.createSeance(seanceDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/seance/{id}")
    public SeanceDto updateSeance(@RequestBody @Valid SeanceDto seanceDto){
        return seanceService.updateSeance(seanceDto);
    }

    @DeleteMapping(value = "/seance/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id){
        seanceService.deleteSeance(id);
        return ResponseEntity.noContent().build();
    }
}
