package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.UserDto;
import com.vasilisa.cinema.service.UserService;
import com.vasilisa.cinema.model.User;
import com.vasilisa.cinema.repository.UserRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        log.info("get all users");
        return UserMapper.INSTANCE.mapUserDtos(userRepository.getAllUsers());
    }

    @Override
    public UserDto getUser(int id) {
        log.info("get user by id {}", id);
        User user = userRepository.getUser(id);
        if (user == null) {
            throw new EntityNotFoundException(format("User with id %s not found", id));
        }
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("create user with id {}", userDto.getId());
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.createUser(user);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        log.info("update user with id {}", id);
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.updateUser(id, user);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public void deleteUser(int id) {
        log.info("delete user with id {}", id);
        userRepository.deleteUser(id);
    }
}
