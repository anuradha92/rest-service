package com.anuradha.crud.controller;

import com.anuradha.crud.entity.User;
import com.anuradha.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * Author Anuradha Gunasinghe
 * This sample for CRUD operation
 * This controller class is used to expose User API
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * this method is used to save user information
     *
     * @param user this is the user entity
     * @return user registry information
     */
    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        if (log.isDebugEnabled()) {
            log.debug("Executing saveUser method.");
        }
        User userRegistor = userService.saveUser(user);
        return new ResponseEntity<>(userRegistor, HttpStatus.CREATED);
    }

    /**
     * This method is used to retrive user details using user Id
     *
     * @param userId this user id is refered to primary key in user table
     * @return return searched user details
     */
    @GetMapping("/{id}")
    public Optional<User> getUserByID(@PathVariable("id") Long userId) {
        if (log.isDebugEnabled()) {
            log.debug("Executing getUserById method.");
        }
        Optional<User> userInfo = userService.getUserDetailsById(userId);
        if (log.isDebugEnabled()) {
            log.debug("retrive completed.");
        }
        return userInfo;
    }

    /**
     * This method is used to update user details
     *
     * @param user this is the user entity
     * @return return updated user information
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUserEmail(@RequestBody User user) {
        if (log.isDebugEnabled()) {
            log.debug("Executing updateUser method.");
        }
        User updatedUser = null;
        if (user.getId() != null) {
            if (log.isDebugEnabled()) {
                log.debug("Update user, " + user);
            }
            updatedUser = userService.updateUserDetails(user);
            if (log.isDebugEnabled()) {
                log.debug("User successfully updated., ", updatedUser);
            }
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            String errorMsg = "User id is null.";
            log.error(errorMsg);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * This method is used to delete user details using user Id
     *
     * @param userId this user id is refered to primary key in user table
     * @return return http status 204 with no content
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        if (log.isDebugEnabled()) {
            log.debug("Executing deleteUser method.");
        }
        userService.deleteUserById(userId);
        if (log.isDebugEnabled()) {
            log.debug("Successfully deleted.");
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
