package com.gym.javavalidatedform.service;

import com.gym.javavalidatedform.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

    Page<User> findAll(Pageable pageable);

    User save(User user);

}
