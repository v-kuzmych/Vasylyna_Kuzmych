package com.vasilisa.cinema.repository.impl;

import com.vasilisa.cinema.model.User;
import com.vasilisa.cinema.repository.UserRepository;
import com.vasilisa.cinema.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(list);
    }

    @Override
    public User getUser(int id) {
        return list.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setDate(LocalDateTime.now());
        user.setRole("user");
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        boolean isDeleted = list.removeIf(u -> u.getId() == id);
        if (isDeleted){
            list.add(user);
        } else {
            throw new EntityNotFoundException(format("User with id %s not found", id));
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
