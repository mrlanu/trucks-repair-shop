package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Vehicle;
import com.lanu.trucks_repair_shop.repositories.PartRepository;
import com.lanu.trucks_repair_shop.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Override
    public void createPart(Part part, Vehicle vehicle) {
        part.setVehicle(vehicle);
        partRepository.save(part);
    }

    public void save(Part part){
        partRepository.save(part);
    }

    public List<Part> findVehicleParts(Vehicle vehicle){
        return partRepository.findByVehicle(vehicle);
    }
}
