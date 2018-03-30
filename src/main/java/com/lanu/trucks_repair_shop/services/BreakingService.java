package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.domain.Breaking;
import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;

import java.util.List;

public interface BreakingService {

    void save(Breaking breaking);

    List<Breaking> findBreakingsListByVehicle(Vehicle vehicle);
}
