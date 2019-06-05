package com.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.beans.annotation.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository1;


    @Autowired
    @Qualifier("userJdbcRepository")
    private UserRepository userJdbcRepository;

    public void setRepository(UserRepository userRepository) {
        this.userRepository1 = userRepository;
    }
    public void add() {
        System.out.println("UserService add");
        userRepository1.save();
        userJdbcRepository.save();
    }
}
