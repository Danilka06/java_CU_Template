package com.example.Project.services.interfaces;

import com.example.Project.model.entity.Users;

public interface UserServiceInterface {

    Users createUser(Users user);

    Users readUserById(int id);

    Users updateUserById(Users user);

    Users deleteUserById(int id);
}
