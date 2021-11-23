package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers(Pageable pageable);

    UserDto getUser(Long id);

    UserDto createUser(UserDto userDTO);

    UserDto updateUser(UserDto userDTO);

    void deleteUser(Long id);
}
