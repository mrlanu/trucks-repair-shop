package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Integer> {
    List<Part> findByVehicle(Vehicle vehicle);
}
