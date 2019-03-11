package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl {
    private UserRepository userRepository;

    @Autowired
    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();

    }

    public User getUserById(int id) {
        Optional<User> founduserbyId = userRepository.findById(id);
        return founduserbyId.get();
    }

    public void deleteUser(User user, int Id) {
        userRepository.deleteById(Id);
    }

    public User updateUser(User user, int id) {
        User finduser = userRepository.findById(id).get();
        finduser.setName(user.getName());
        finduser.setAge(user.getAge());
        finduser.setGender(user.getGender());
        return userRepository.save(finduser);
    }
}

