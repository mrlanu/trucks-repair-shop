package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Vehicle findByNumber(Integer number);

}
