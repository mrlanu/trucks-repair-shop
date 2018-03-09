package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.entities.Vehicle;
import com.lanu.trucks_repair_shop.repositories.VehicleRepository;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findByNumber(Integer number) {
        return vehicleRepository.findByNumber(number);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
