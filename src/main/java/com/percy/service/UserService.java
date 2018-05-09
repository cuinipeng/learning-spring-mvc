package com.percy.service;

import com.percy.repository.JdbcUserRepository;
import com.percy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private JdbcUserRepository userRepository;

    @Autowired
    public UserService(JdbcUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}
