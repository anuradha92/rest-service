package com.test.sampleProject.service;

import com.test.sampleProject.entity.User;

public interface UserService {
    User saveUser(User user);

    User getUserDetailsById(Long userId);

    User updateUserDetails(User user);

    void deleteUserById(Long userId);
}
