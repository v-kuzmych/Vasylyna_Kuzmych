package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.FilmDto;
import com.vasilisa.cinema.mapper.UserMapper;
import com.vasilisa.cinema.model.Film;
import com.vasilisa.cinema.model.FilmDescription;
import com.vasilisa.cinema.model.Language;
import com.vasilisa.cinema.model.User;
import com.vasilisa.cinema.service.FilmService;
import com.vasilisa.cinema.repository.FilmRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.mapper.FilmMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public List<FilmDto> getAllFilms(Pageable pageable) {
        log.info("get all films");
        Page<Film> pagedResult = filmRepository.findAll(pageable);

        if (!pagedResult.hasContent()) {
            throw new EntityNotFoundException(format("Films not found"));
        }

        return FilmMapper.INSTANCE.mapFilmDtos(pagedResult.getContent());
    }

    @Override
    public FilmDto getFilm(Long id) {
        log.info("get film by id {}", id);
        Film film = filmRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(format("Film with id %s not found", id)));
        return FilmMapper.INSTANCE.mapFilmDto(film);
    }

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        Film film = FilmMapper.INSTANCE.mapFilm(filmDto);
        film = filmRepository.save(film);
        log.info("create user with id {}", film.getId());
        return FilmMapper.INSTANCE.mapFilmDto(film);
    }

    @Override
    public FilmDto updateFilm(FilmDto filmDto) {
        Long id = filmDto.getId();
        log.info("update film with id {}", id);
        if (!filmRepository.existsById(id)){
            throw new EntityNotFoundException(format("Film with id %s not found", id));
        }
        Film film = FilmMapper.INSTANCE.mapFilm(filmDto);
        film = filmRepository.save(film);
        return FilmMapper.INSTANCE.mapFilmDto(film);
    }

    @Override
    public void deleteFilm(Long id) {
        log.info("delete film with id {}", id);
        if (!filmRepository.existsById(id)){
            throw new EntityNotFoundException(format("Film with id %s not found", id));
        }
        filmRepository.deleteById(id);
    }
}
