package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreakingRepository extends JpaRepository<Breaking, Integer> {

    Breaking findByBreakingId(Integer id);
}
