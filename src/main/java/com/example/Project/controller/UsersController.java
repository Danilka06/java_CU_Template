package com.example.Project.controller;

import com.example.Project.model.entity.Users;
import com.example.Project.services.UsersService;
import com.example.Project.services.interfaces.UserServiceInterface;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController implements UserServiceInterface {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping()
    public Users createUser(@Valid @RequestBody Users users) {
        return this.usersService.createUser(users);
    }

    @GetMapping("/{id}")
    public Users readUserById(@PathVariable int id) {
        return this.usersService.getUserById(id);
    }

    @PatchMapping()
    public Users updateUserById(@Valid @RequestBody Users users) {
        return this.usersService.updateUserById(users);
    }

    @DeleteMapping("/{id}")
    public Users deleteUserById(@PathVariable int id) {
        return this.usersService.deleteUserById(id);
    }
}
