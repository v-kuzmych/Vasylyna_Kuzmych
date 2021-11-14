package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmDescriptionDTO {
    int id;
    int filmId;
    int languageId;
    String name;
    String description;
}
