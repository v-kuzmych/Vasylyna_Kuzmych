package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class FilmDto {

    @Positive
    int id;

    @NotBlank
    String img;

    @Positive
    int duration;

    @NotEmpty
    List<FilmDescriptionDto> filmDescriptions;
}
