package com.lanu.trucks_repair_shop.services.security_services;

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();
    T getById(Integer id);
    T saveOrUpdate(T domainObject);
    void delete(Integer id);
}
