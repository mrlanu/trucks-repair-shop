package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MakeRepository extends JpaRepository<Make, Integer> {

    Make findByName(String name);
    Make findByMakeId(Integer id);
    List<Make> findByTypeOfVehicle(String type);
}
