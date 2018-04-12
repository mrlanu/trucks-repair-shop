package com.lanu.trucks_repair_shop.services.services_impl.security_services_impl;

import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.domain.security.Users;
import com.lanu.trucks_repair_shop.repositories.security_repositories.UserRepository;
import com.lanu.trucks_repair_shop.services.security_services.RoleService;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<?> listAll() {
        List<Users> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Users getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public Users saveOrUpdate(Users domainObject) {
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

    public void createUser(Users user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.addRole(roleService.findByName("ROLE_USER"));
        userRepository.save(user);
    }
}
