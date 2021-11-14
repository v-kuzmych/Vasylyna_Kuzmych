package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FilmDTO {
    int id;
    String img;
    int duration;
    List<FilmDescriptionDTO> filmDescriptions;
}
