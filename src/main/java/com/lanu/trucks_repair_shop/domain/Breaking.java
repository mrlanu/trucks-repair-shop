package com.lanu.trucks_repair_shop.domain;

import javax.persistence.*;

@Entity
public class Breaking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;
    private int milage;

    @ManyToOne
    @JoinColumn(name = "vehicle_number")
    private Vehicle vehicle;

    public Breaking(){}

    public Breaking(String date, int milage) {
        this.date = date;
        this.milage = milage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
