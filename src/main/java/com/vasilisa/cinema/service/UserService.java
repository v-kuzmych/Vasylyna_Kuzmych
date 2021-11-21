package com.vasilisa.cinema.service;

import com.vasilisa.cinema.controller.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUser(int id);

    UserDto createUser(UserDto userDTO);

    UserDto updateUser(int id, UserDto userDTO);

    void deleteUser(int id);
}
