package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Vehicle findByNumber(Integer number);

}
