package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.entities.Breaking;
import com.lanu.trucks_repair_shop.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreakingRepository extends JpaRepository<Breaking, Long> {
    List<Breaking> findByUnit(Unit unit);
}
