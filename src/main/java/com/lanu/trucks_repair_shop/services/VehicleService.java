package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;

import java.security.Principal;
import java.util.List;

public interface VehicleService {

    void save(Vehicle vehicle);

    Vehicle findByNumber(Integer number);

    List<Vehicle> findAll();

    boolean isVehiclePresent(Vehicle vehicle);

    void deleteVehicle(Integer number);

    void createBreaking(Integer[] breakingKind, String[] descriptionList,
                        Integer vehicleNumber, Principal principal, Breaking breaking);
}
