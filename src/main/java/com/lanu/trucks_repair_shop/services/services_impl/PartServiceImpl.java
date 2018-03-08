package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Unit;
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
    public void createPart(Part part, Unit unit) {
        part.setUnit(unit);
        partRepository.save(part);
    }

    public void save(Part part){
        partRepository.save(part);
    }

    public List<Part> findUnitParts(Unit unit){
        return partRepository.findByUnit(unit);
    }
}
