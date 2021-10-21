package com.anuradha.CRUD_Operation.service;

import com.anuradha.CRUD_Operation.entity.User;

public interface UserService {
    User saveUser(User user);

    User getUserDetailsById(Long userId);

    User updateUserDetails(User user);

    void deleteUserById(Long userId);
}
