package com.anuradha.crud.service;

import com.anuradha.crud.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserDetailsById(Long userId);

    User updateUserDetails(User user);

    void deleteUserById(Long userId);
}
