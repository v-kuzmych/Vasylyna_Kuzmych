package com.vasilisa.cinema.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    int id;
    String name;
    String email;
    String password;
}
