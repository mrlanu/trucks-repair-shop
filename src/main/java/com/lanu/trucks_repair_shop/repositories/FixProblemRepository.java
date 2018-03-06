package com.lanu.trucks_repair_shop.repositories;

import com.lanu.trucks_repair_shop.entities.FixProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixProblemRepository extends JpaRepository<FixProblem, Long> {
}
