package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.FilmDTO;
import com.vasilisa.cinema.service.FilmService;
import com.vasilisa.cinema.model.Film;
import com.vasilisa.cinema.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public List<FilmDTO> getAllFilms() {
        log.info("get all films");
        return filmRepository.getAllFilms()
                .stream()
                .map(this::mapFilmToFilmDto)
                .collect(Collectors.toList());
    }

    @Override
    public FilmDTO getFilm(int id) {
        log.info("get film by id {}", id);
        Film film = filmRepository.getFilm(id);
        return mapFilmToFilmDto(film);
    }

    @Override
    public FilmDTO createFilm(FilmDTO filmDTO) {
        log.info("create film with id {}", filmDTO.getId());
        Film film = mapFilmDtoToFilm(filmDTO);
        film = filmRepository.createFilm(film);
        return mapFilmToFilmDto(film);
    }

    @Override
    public FilmDTO updateFilm(int id, FilmDTO filmDTO) {
        log.info("update film with id {}", id);
        Film film = mapFilmDtoToFilm(filmDTO);
        film = filmRepository.updateFilm(id, film);
        return mapFilmToFilmDto(film);
    }

    @Override
    public void deleteFilm(int id) {
        log.info("delete film with id {}", id);
        filmRepository.deleteFilm(id);
    }

    private FilmDTO mapFilmToFilmDto(Film film){
        return FilmDTO.builder()
                .id(film.getId())
                .img(film.getImg())
                .duration(film.getDuration())
                .filmDescriptions(film.getFilmDescriptions())
                .build();
    }

    private Film mapFilmDtoToFilm(FilmDTO filmDTO){
        return Film.builder()
                .id(filmDTO.getId())
                .img(filmDTO.getImg())
                .duration(filmDTO.getDuration())
                .filmDescriptions(filmDTO.getFilmDescriptions())
                .build();
    }
}
