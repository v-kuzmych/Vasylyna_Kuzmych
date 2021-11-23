package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.dto.UserDto;
import com.vasilisa.cinema.mapper.OrderMapper;
import com.vasilisa.cinema.model.Order;
import com.vasilisa.cinema.service.UserService;
import com.vasilisa.cinema.model.User;
import com.vasilisa.cinema.repository.UserRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import com.vasilisa.cinema.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers(Pageable pageable) {
        log.info("get all users");
        Page<User> pagedResult = userRepository.findAll(pageable);

        if (!pagedResult.hasContent()) {
            throw new EntityNotFoundException(format("Orders not found"));
        }

        return UserMapper.INSTANCE.mapUserDtos(pagedResult.getContent());
    }

    @Override
    public UserDto getUser(Long id) {
        log.info("get user by id {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(format("User with id %s not found", id)));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.save(user);
        log.info("create user with id {}", user.getId());
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Long id = userDto.getId();
        log.info("update user with id {}", id);
        if (!userRepository.existsById(id)){
            throw new EntityNotFoundException(format("User with id %s not found", id));
        }
        User user = UserMapper.INSTANCE.mapUser(userDto);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("delete user with id {}", id);
        if (!userRepository.existsById(id)){
            throw new EntityNotFoundException(format("User with id %s not found", id));
        }
        userRepository.deleteById(id);
    }
}
