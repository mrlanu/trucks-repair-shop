package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Unit;
import com.lanu.trucks_repair_shop.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public void createUnit(Unit unit){
        unitRepository.save(unit);
    }

    public Unit findOne(long id){
        return unitRepository.findOne(id);
    }
}
