package com.gym.javavalidatedform.repository;

import com.gym.javavalidatedform.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
