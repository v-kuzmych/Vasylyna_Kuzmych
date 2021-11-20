package com.vasilisa.cinema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmDescription {
    int id;
    int filmId;
    int languageId;
    String name;
    String description;
}
