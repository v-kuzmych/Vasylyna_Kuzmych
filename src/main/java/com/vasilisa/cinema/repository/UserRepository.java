package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUser(int id);

    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
