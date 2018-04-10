package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreakingRepository extends JpaRepository<Breaking, Integer> {

    Breaking findByBreakingId(Integer id);

    List<Breaking> findByVehicle(Vehicle vehicle);
}
