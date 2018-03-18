package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.domain.security.User;

public interface UserService extends CRUDService<User> {
    User findByUsername(String username);
    void createUser(User user);
}
