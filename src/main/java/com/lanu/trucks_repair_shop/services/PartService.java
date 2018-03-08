package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Unit;

import java.util.List;

public interface PartService {

    void createPart(Part part, Unit unit);

    List<Part> findUnitParts(Unit unit);
}
