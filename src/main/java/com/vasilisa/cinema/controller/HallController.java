package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.dto.HallDto;
import com.vasilisa.cinema.service.HallService;
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
public class HallController {

    private final HallService hallService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/halls")
    public List<HallDto> getAllHalls(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return hallService.getAllHalls(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/hall/{id}")
    public HallDto getHall(@PathVariable Long id){
        return hallService.getHall(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/hall")
    public HallDto createHall(@Valid @RequestBody HallDto hallDto){
        return hallService.createHall(hallDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/hall/{id}")
    public HallDto updateHall(@RequestBody @Valid HallDto hallDto){
        return hallService.updateHall(hallDto);
    }

    @DeleteMapping(value = "/hall/{id}")
    public ResponseEntity<Void> deleteHall(@PathVariable Long id){
        hallService.deleteHall(id);
        return ResponseEntity.noContent().build();
    }
}
