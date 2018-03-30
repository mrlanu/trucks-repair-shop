package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.domain.Breaking;
import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
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
    public void save(Breaking breaking) {
        breakingRepository.save(breaking);
    }

    @Override
    public List<Breaking> findBreakingsListByVehicle(Vehicle vehicle) {
        return breakingRepository.findByVehicle(vehicle);
    }
}
