package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
