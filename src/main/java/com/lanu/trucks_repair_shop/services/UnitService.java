package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Unit;

import java.util.List;

public interface UnitService {

    void save(Unit unit);

    List<Unit> findByType(String type);
}
