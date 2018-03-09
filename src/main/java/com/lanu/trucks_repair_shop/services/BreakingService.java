package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Breaking;
import com.lanu.trucks_repair_shop.entities.Vehicle;

import java.util.List;

public interface BreakingService {

    void createBreaking(Breaking breaking, Vehicle vehicle);

    List<Breaking> findVehicleBreakings(Vehicle vehicle);
}
