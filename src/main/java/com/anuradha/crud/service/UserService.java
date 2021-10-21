package com.anuradha.crud.service;

import com.anuradha.crud.entity.User;

public interface UserService {
    User saveUser(User user);

    User getUserDetailsById(Long userId);

    User updateUserDetails(User user);

    void deleteUserById(Long userId);
}
