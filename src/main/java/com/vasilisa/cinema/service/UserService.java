package com.vasilisa.cinema.service;

import com.vasilisa.cinema.controller.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUser(int id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(int id, UserDTO userDTO);

    void deleteUser(int id);
}
