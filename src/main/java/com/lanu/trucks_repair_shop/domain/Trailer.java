package com.lanu.trucks_repair_shop.domain;

import javax.persistence.Entity;

@Entity
public class Trailer extends Vehicle{

    private int length;

    private boolean reefer;

    public Trailer(){}

    public Trailer(Integer number,
                   String vinNumber,
                   String type,
                   String make,
                   String model,
                   String year,
                   int length,
                   boolean reefer) {
        super(number, vinNumber, type, make, model, year);
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
