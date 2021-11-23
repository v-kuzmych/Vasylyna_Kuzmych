package com.vasilisa.cinema.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class LanguageDto {

    @Positive
    private int id;

    @NotBlank
    private String locale;

    @NotBlank
    private String shortName;

    @NotBlank
    private String fullName;
}
