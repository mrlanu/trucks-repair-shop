package com.lanu.trucks_repair_shop.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Unit {

    @Id
    @Column(unique = true)
    private Long vinNumber;

    @Column(unique = true)
    private int number;

    private String type;

    private String make;

    private String model;

    private int year;

    public Unit(){}

    public Unit(Long vinNumber, int number, String type, String make, String model, int year) {
        this.vinNumber = vinNumber;
        this.number = number;
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
    private List<Part> partList;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
    private List<Breaking> breakingList;

    public Long getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(Long vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    @Override
    public String toString() {
        return "Unit{" +
                "vinNumber=" + vinNumber +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
