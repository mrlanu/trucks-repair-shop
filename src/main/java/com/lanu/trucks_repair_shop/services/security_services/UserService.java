package com.lanu.trucks_repair_shop.services.security_services;

import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.services.security_services.CRUDService;

public interface UserService extends CRUDService<User> {
    User findByUsername(String username);
    void createUser(User user);
}
