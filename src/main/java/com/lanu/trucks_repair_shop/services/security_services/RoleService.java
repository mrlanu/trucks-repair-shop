package com.lanu.trucks_repair_shop.services.security_services;

import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.services.security_services.CRUDService;

public interface RoleService {

    Role findByName(String roleName);

    void save(Role role);
}
