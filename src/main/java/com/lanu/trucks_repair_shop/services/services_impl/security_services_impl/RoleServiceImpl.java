package com.lanu.trucks_repair_shop.services.services_impl.security_services_impl;

import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.repositories.security_repositories.RoleRepository;
import com.lanu.trucks_repair_shop.services.security_services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
