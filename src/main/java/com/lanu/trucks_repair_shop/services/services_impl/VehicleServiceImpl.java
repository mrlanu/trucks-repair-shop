package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.domain.Breaking;
import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import com.lanu.trucks_repair_shop.repositories.MakeRepository;
import com.lanu.trucks_repair_shop.repositories.VehicleRepository;
import com.lanu.trucks_repair_shop.services.BreakingService;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private MakeRepository makeRepository;

    @Autowired
    private BreakingService breakingService;

    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void createBreaking(Vehicle vehicle, Breaking breaking) {
        vehicle.setBroken(true);
        vehicleRepository.save(vehicle);
        breaking.setVehicle(vehicle);
        breakingService.save(breaking);
    }

    @Override
    public Vehicle findByNumber(Integer number) {
        return vehicleRepository.findByNumber(number);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public boolean isVehiclePresent(Vehicle vehicle) {
        return vehicleRepository.findByNumber(vehicle.getNumber()) != null ? true:false;
    }

    @Override
    public void deleteVehicle(Integer number) {
        vehicleRepository.delete(number);
    }
}
