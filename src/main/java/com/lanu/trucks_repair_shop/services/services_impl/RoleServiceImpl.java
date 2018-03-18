package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.repositories.RoleRepository;
import com.lanu.trucks_repair_shop.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
    public class RoleServiceImpl implements RoleService {

        @Autowired
        private RoleRepository roleRepository;

        @Override
        public List<?> listAll() {
            List<Role> roles = new ArrayList<>();
            roleRepository.findAll().forEach(roles::add);
            return roles;
        }

        @Override
        public Role getById(Integer id) {
            return roleRepository.findOne(id);
        }

        @Override
        public Role saveOrUpdate(Role domainObject) {
            return roleRepository.save(domainObject);
        }

        @Override
        public void delete(Integer id) {
            roleRepository.delete(id);
        }
    }
