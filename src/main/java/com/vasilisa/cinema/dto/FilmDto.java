package com.vasilisa.cinema.dto;

import com.vasilisa.cinema.model.FilmDescription;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
public class FilmDto {

    @Positive
    private Long id;

    @NotBlank
    private String img;

    @Positive
    private int duration;

    @NotEmpty
    private List<FilmDescription> filmDescriptions;
}
