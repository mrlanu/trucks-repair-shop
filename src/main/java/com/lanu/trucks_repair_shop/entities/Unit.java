package com.lanu.trucks_repair_shop.entities;

import java.util.List;

public class Unit {

    private Long vinNumber;
    private String kind;
    private int number;
    private int year;

    private List<Part> partList;

    private List<Breaking> breakingList;

    public Unit(){}

    public Unit(Long vinNumber, String kind, int number, int year) {
        this.vinNumber = vinNumber;
        this.kind = kind;
        this.number = number;
        this.year = year;
    }

    public Long getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(Long vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
