package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.dto.FilmDto;
import com.vasilisa.cinema.model.Film;
import com.vasilisa.cinema.service.FilmService;
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
public class FilmController {

    private final FilmService filmService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/films")
    public List<FilmDto> getAllFilms(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return filmService.getAllFilms(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/film/{id}")
    public FilmDto getFilm(@PathVariable Long id){
        return filmService.getFilm(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/film")
    public FilmDto createFilm(@Valid @RequestBody FilmDto filmDto){
        return filmService.createFilm(filmDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/film/{id}")
    public FilmDto updateFilm(@RequestBody @Valid FilmDto filmDto){
        return filmService.updateFilm(filmDto);
    }

    @DeleteMapping(value = "/film/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id){
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
