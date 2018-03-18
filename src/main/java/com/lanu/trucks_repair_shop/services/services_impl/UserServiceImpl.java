package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.repositories.UserRepository;
import com.lanu.trucks_repair_shop.services.RoleService;
import com.lanu.trucks_repair_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

  //  @Autowired
  //  private EncryptionService encryptionService;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
       /* if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        return userRepository.save(domainObject);*/
       return null;
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        roleService.saveOrUpdate(userRole);
        userRepository.save(user);
    }
}
