package com.vasilisa.cinema.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
public class LanguageDto {

    @Positive
    int id;

    @NotBlank
    String locale;

    @NotBlank
    String shortName;

    @NotBlank
    String fullName;
}
