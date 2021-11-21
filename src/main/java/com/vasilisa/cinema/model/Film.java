package com.vasilisa.cinema.model;

import com.vasilisa.cinema.controller.dto.FilmDescriptionDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Film {
    int id;
    String img;
    int duration;
    List<FilmDescriptionDto> filmDescriptions;
}
