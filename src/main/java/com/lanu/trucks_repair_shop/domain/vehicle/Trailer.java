package com.lanu.trucks_repair_shop.domain.vehicle;

import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;

import javax.persistence.Entity;

@Entity
public class Trailer extends Vehicle {

    private int length;

    private boolean reefer;

    public Trailer(){}

    public Trailer(String type) {
        super(type);
    }

    public Trailer(Integer number,
                   String vinNumber,
                   String type,
                   String year,
                   int length,
                   boolean reefer) {
        super(number, vinNumber, type, year);
        this.length = length;
        this.reefer = reefer;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isReefer() {
        return reefer;
    }

    public void setReefer(boolean reefer) {
        this.reefer = reefer;
    }
}
