package com.anuradha.crud.service.ServiceImpl;

import com.anuradha.crud.entity.User;
import com.anuradha.crud.repository.UserRepository;
import com.anuradha.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * This method is use to save user details in db via user repository
     *
     * @param user this is user entity
     * @return return user details with response
     */
    @Override
    public User saveUser(User user) {
        if (log.isDebugEnabled()) {
            log.debug("Executing saveUser.");
        }
        return userRepository.save(user);
    }

    /**
     * This method is used to get user information using user id
     *
     * @param userId this user id is refered to primary key in user table
     * @return return user details
     */
    @Override
    public Optional<User> getUserDetailsById(Long userId) {
        if (log.isDebugEnabled()) {
            log.debug("Executing getUserDetailsById.");
        }
        return userRepository.findById(userId);
    }

    /**
     * This method is used to update user details
     *
     * @param user this is user entity
     * @return return updated user information
     */
    @Override
    public User updateUserDetails(User user) {
        if (log.isDebugEnabled()) {
            log.debug("Executing updateUserDetails.");
        }
        User updateUser = userRepository.getById(user.getId());
        updateUser.setEmail(user.getEmail());
        return userRepository.save(updateUser);
    }

    /**
     * This method is used to delete user
     *
     * @param userId this user id is refered to primary key in user table
     */
    @Override
    public void deleteUserById(Long userId) {
        if (log.isDebugEnabled()) {
            log.debug("Executing deleteUserById method.");
        }
        userRepository.deleteById(userId);
    }

}
