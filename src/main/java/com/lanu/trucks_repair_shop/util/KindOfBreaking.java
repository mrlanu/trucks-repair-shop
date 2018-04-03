package com.lanu.trucks_repair_shop.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KindOfBreaking {

    private Map<Integer, String> kindMap = new HashMap<>();

    private static Integer id = 0;

    public KindOfBreaking() {
        kindMap.put(id++, "Body");
        kindMap.put(id++, "Engine");
        kindMap.put(id++, "Suspension");
        kindMap.put(id++, "Differential");
        kindMap.put(id++, "Drive shafts");
        kindMap.put(id++, "Transmission");
        kindMap.put(id++, "Tires");
        kindMap.put(id++, "Steering");
        kindMap.put(id++, "Glass");
        kindMap.put(id++, "Electric");
        kindMap.put(id++, "Gauges");
        kindMap.put(id++, "Air leak");
        kindMap.put(id++, "Exhaust");
        kindMap.put(id++, "Brakes");
        kindMap.put(id++, "Frame");
        kindMap.put(id++, "5th wheel");
        kindMap.put(id++, "Battery");
        kindMap.put(id++, "Leaks");
        kindMap.put(id++, "Oil, PM service");
        kindMap.put(id++, "Other");
    }

    public Map<Integer, String> getKindMap() {
        return kindMap;
    }

    private Integer incrementId(){
        return id++;
    }
}
