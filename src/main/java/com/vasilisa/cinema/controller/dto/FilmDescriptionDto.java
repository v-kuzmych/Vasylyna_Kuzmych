package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
public class FilmDescriptionDto {

    @Positive
    int id;

    @Positive
    int filmId;

    @Positive
    int languageId;

    @NotBlank
    String name;

    @NotBlank
    String description;
}
