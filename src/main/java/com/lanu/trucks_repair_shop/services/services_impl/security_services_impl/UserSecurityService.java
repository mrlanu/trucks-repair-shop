package com.lanu.trucks_repair_shop.services.services_impl.security_services_impl;

import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null){
            LOG.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found.");
        }
        return user;
    }
}
