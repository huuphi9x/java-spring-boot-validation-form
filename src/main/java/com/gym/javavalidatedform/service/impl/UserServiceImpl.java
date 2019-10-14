package com.gym.javavalidatedform.service.impl;

import com.gym.javavalidatedform.model.User;
import com.gym.javavalidatedform.repository.UserRepository;
import com.gym.javavalidatedform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
