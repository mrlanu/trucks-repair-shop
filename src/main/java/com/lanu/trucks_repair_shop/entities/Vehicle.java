package com.lanu.trucks_repair_shop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @Column(unique = true)
    @NotNull
    private Integer number;

    @Column(unique = true)
    @Pattern(regexp="[a-zA-Z0-9]{8}")
    private String vinNumber;

    private String type;

    private String make;

    private String model;

    @Pattern(regexp = "^\\d{4}$")
    private String year;

    private boolean isBroken;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Part> partList;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Breaking> breakingList;

    public Vehicle(){}

    public Vehicle(Integer number, String vinNumber, String type, String make, String model, String year) {
        this.number = number;
        this.vinNumber = vinNumber;
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }
}
