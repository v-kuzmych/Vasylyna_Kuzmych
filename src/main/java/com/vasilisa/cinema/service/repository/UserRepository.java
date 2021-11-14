package com.vasilisa.cinema.service.repository;

import com.vasilisa.cinema.service.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUser(int id);

    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
