package com.stackroute.controllers;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import com.stackroute.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserServiceimpl userService;

    @Autowired
    public UserController(UserServiceimpl userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUser(@RequestBody User user) {

        return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);

    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {

        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);

    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable("id") int id) {

        return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
        User updatedUser= userService.updateUser(user, id);
        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }

}
