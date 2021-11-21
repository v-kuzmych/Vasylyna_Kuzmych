package com.vasilisa.cinema.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
public class UserDto {

    @Positive
    int id;

    @NotBlank
    String name;

    @Email
    String email;

    @NotBlank
    String password;
}
