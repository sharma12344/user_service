package com.stackroute.service;

import com.stackroute.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserFSService {

    public User saveUser(User user) {
        return new User();
    }


}
