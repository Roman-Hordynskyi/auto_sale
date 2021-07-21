package com.autosale.application.service;

import com.autosale.application.model.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
}
