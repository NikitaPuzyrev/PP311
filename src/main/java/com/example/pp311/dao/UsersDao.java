package com.example.pp311.dao;

import com.example.pp311.model.User;

import java.util.List;

public interface UsersDao {
    List<User> getAllUsers();

    User showUserById(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}

