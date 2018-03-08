package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.entities.Unit;
import com.lanu.trucks_repair_shop.repositories.UnitRepository;
import com.lanu.trucks_repair_shop.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public void save(Unit unit) {
        unitRepository.save(unit);
    }

    @Override
    public List<Unit> findByTypeLike(String type) {
        return unitRepository.findByTypeLike("%" + type + "%");
    }
}
