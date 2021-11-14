package com.vasilisa.cinema.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Language {
    int id;
    String locale;
    String shortName;
    String fullName;
}
