package com.lanu.trucks_repair_shop.services;

import com.lanu.trucks_repair_shop.entities.Part;
import com.lanu.trucks_repair_shop.entities.Unit;
import com.lanu.trucks_repair_shop.repositories.PartRepository;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;


    public void createPart(Part part, Unit unit){
        part.setUnit(unit);
        partRepository.save(part);
    }

    public List<Part> findUnitParts(Unit unit){
        return partRepository.findByUnit(unit);
    }
}
