package com.lanu.trucks_repair_shop.domain.security;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role extends AbstractDomainClass {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    public Role(){}

    public Role(String name) {
        this.name = "ROLE_" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
