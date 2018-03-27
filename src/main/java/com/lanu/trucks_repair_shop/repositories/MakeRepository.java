package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeRepository extends JpaRepository<Make, Integer> {

    Make findByName(String name);
}
