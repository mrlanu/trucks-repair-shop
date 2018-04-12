package com.lanu.trucks_repair_shop.repositories.security_repositories;

import com.lanu.trucks_repair_shop.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String roleName);
}
