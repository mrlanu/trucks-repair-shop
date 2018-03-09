package com.lanu.trucks_repair_shop.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @Column(unique = true)
    private Integer number;

    @Column(unique = true)
    @NotEmpty
    @Length(min = 8)
    private String vinNumber;

    private String type;

    private String make;

    private String model;

    private int year;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Part> partList;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Breaking> breakingList;

    public Vehicle(){}

    public Vehicle(Integer number, String vinNumber, String type, String make, String model, int year) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "number=" + number +
                ", vinNumber='" + vinNumber + '\'' +
                ", type='" + type + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
