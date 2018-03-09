package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Vehicle;

import java.util.List;

public interface PartService {

    void createPart(Part part, Vehicle vehicle);

    List<Part> findVehicleParts(Vehicle vehicle);
}
