package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.domain.vehicle.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
