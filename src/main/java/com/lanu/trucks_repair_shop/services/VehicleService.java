package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.domain.Breaking;
import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;

import java.util.List;

public interface VehicleService {

    void createBreaking(Vehicle vehicle, Breaking breaking);

    void save(Vehicle vehicle, String make);

    Vehicle findByNumber(Integer number);

    List<Vehicle> findAll();

    boolean isVehiclePresent(Vehicle vehicle);

    void deleteVehicle(Integer number);
}
