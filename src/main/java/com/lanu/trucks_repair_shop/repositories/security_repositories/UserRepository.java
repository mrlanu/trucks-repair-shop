package com.lanu.trucks_repair_shop.repositories.security_repositories;

import com.lanu.trucks_repair_shop.domain.security.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);
}
