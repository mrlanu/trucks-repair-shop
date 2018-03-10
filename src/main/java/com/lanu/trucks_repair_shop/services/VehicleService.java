package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Truck;
import com.lanu.trucks_repair_shop.entities.Vehicle;

import java.util.List;

public interface VehicleService {

    void save(Vehicle vehicle);

    Vehicle findByNumber(Integer number);

    List<Vehicle> findAll();

    boolean isVehiclePresent(Truck truck);
}
