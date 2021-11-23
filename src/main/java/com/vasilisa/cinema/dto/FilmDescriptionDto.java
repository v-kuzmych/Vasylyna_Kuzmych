package com.vasilisa.cinema.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class FilmDescriptionDto {

    @Positive
    private Long id;

    private LanguageDto language;

    private FilmDto film;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
