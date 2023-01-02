package com.ab.user.service.services;

import com.ab.user.service.entities.User;

import java.util.List;

public interface UserService {
    //user operation

    //create user
    User saveUser(User user);

    //get all Users
    List<User> getAllUsers();

    //get single user of given Id
    User getUser(String userId);

    //update User
    User updateUser(User user);

    //Delete User
    User deleteUser(String userId);
}
