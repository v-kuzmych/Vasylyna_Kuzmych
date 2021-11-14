package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.controller.dto.HallDTO;
import com.vasilisa.cinema.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/halls")
    public List<HallDTO> getAllHalls(){
        return hallService.getAllHalls();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/hall/{id}")
    public HallDTO getHall(@PathVariable int id){
        return hallService.getHall(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/hall")
    public HallDTO createHall(@RequestBody HallDTO hallDTO){
        return hallService.createHall(hallDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/hall/{id}")
    public HallDTO updateHall(@PathVariable int id, @RequestBody HallDTO hallDTO){
        return hallService.updateHall(id, hallDTO);
    }

    @DeleteMapping(value = "/hall/{id}")
    public ResponseEntity<Void> deleteHall(@PathVariable int id){
        hallService.deleteHall(id);
        return ResponseEntity.noContent().build();
    }
}
