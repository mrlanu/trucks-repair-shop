package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findByType(String type);
}
