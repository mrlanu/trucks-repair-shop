package com.lanu.trucks_repair_shop.domain.vehicle;

import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;

import javax.persistence.Entity;

@Entity
public class Truck extends Vehicle {

    private String engineType;

    public Truck(){}

    public Truck(String engineType,
                 Integer number,
                 String vinNumber,
                 String type,
                 String make,
                 String model,
                 String year) {
        super(number, vinNumber, type, make, model, year);
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

}
