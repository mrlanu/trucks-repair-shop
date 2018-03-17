package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.domain.User;

public interface UserService extends CRUDService<User> {
    User findByUsername(String username);
}
