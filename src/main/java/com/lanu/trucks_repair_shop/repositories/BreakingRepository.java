package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.entities.Breaking;
import com.lanu.trucks_repair_shop.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreakingRepository extends JpaRepository<Breaking, Integer> {
    List<Breaking> findByVehicle(Vehicle vehicle);
}
