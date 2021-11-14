package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.UserDTO;
import com.vasilisa.cinema.service.UserService;
import com.vasilisa.cinema.service.model.User;
import com.vasilisa.cinema.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("get all users");
        return userRepository.getAllUsers()
                .stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(int id) {
        log.info("get user by id {}", id);
        User user = userRepository.getUser(id);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("create user with id {}", userDTO.getId());
        User user = mapUserDtoToUser(userDTO);
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userDTO) {
        log.info("update user with id {}", id);
        User user = mapUserDtoToUser(userDTO);
        user = userRepository.updateUser(id, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(int id) {
        log.info("delete user with id {}", id);
        userRepository.deleteUser(id);
    }

    private UserDTO mapUserToUserDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    private User mapUserDtoToUser(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}
