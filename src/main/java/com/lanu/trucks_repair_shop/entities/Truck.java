package com.lanu.trucks_repair_shop.entities;

import java.util.List;

public class Truck {

    private Long vinNumber;
    private int unitNumber;
    private int year;

    private List<Part> partList;

    private List<Breaking> breakingList;

    public Truck() {}

    public Truck(Long vinNumber, int unitNumber, int year) {
        this.vinNumber = vinNumber;
        this.unitNumber = unitNumber;
        this.year = year;
    }

    public Long getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(Long vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

    public List<Breaking> getBreakingList() {
        return breakingList;
    }

    public void setBreakingList(List<Breaking> breakingList) {
        this.breakingList = breakingList;
    }
}
