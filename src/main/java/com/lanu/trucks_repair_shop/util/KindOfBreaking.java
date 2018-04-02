package com.lanu.trucks_repair_shop.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KindOfBreaking {

    private Map<Integer, String> kindMap = new HashMap<>();

    private static KindOfBreaking ourInstance = new KindOfBreaking();

    public static KindOfBreaking getInstance() {
        return ourInstance;
    }

    private KindOfBreaking() {
        kindMap.put(0, "Breaks");
        kindMap.put(1, "Tires");
        kindMap.put(2, "Air");
        kindMap.put(3, "Windshield");
        kindMap.put(4, "Oil");
    }

    public Map<Integer, String> getKindMap() {
        return kindMap;
    }
}
