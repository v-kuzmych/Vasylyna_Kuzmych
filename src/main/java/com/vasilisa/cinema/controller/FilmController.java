package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.controller.dto.FilmDTO;
import com.vasilisa.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/films")
    public List<FilmDTO> getAllFilms(){
        return filmService.getAllFilms();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/film/{id}")
    public FilmDTO getFilm(@PathVariable int id){
        return filmService.getFilm(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/film")
    public FilmDTO createFilm(@RequestBody FilmDTO filmDTO){
        return filmService.createFilm(filmDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/film/{id}")
    public FilmDTO updateFilm(@PathVariable int id, @RequestBody FilmDTO filmDTO){
        return filmService.updateFilm(id, filmDTO);
    }

    @DeleteMapping(value = "/film/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable int id){
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
