package com.lanu.trucks_repair_shop.services.security_services;

import com.lanu.trucks_repair_shop.domain.security.Users;

public interface UserService extends CRUDService<Users> {
    Users findByUsername(String username);
    void createUser(Users user);
}
