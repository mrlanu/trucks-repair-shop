package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Breaking;
import com.lanu.trucks_repair_shop.entities.Unit;

import java.util.List;

public interface BreakingService {

    void createBreaking(Breaking breaking, Unit unit);

    List<Breaking> findUnitBreakings(Unit unit);
}
