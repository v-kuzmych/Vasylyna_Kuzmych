package com.vasilisa.cinema.service.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    int id;
    String name;
    String email;
    String password;
    String role;
    LocalDateTime date;
}
