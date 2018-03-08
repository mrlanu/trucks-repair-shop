package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.entities.Breaking;
import com.lanu.trucks_repair_shop.entities.Unit;
import com.lanu.trucks_repair_shop.repositories.BreakingRepository;
import com.lanu.trucks_repair_shop.services.BreakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreakingServiceImpl implements BreakingService {

    @Autowired
    private BreakingRepository breakingRepository;

    @Override
    public void createBreaking(Breaking breaking, Unit unit) {
        breaking.setUnit(unit);
        breakingRepository.save(breaking);
    }

    @Override
    public List<Breaking> findUnitBreakings(Unit unit) {
        return breakingRepository.findByUnit(unit);
    }
}
