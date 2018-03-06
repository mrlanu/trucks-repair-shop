package com.lanu.trucks_repair_shop.entities;

import java.util.Date;

public class Part {

    private Long id;
    private String name;
    private Date dateOfPurchase;
    private Date dateOfInstal;
    private boolean isInstaled;
    private Truck truck;
    private Long milage;

    public Part(){}

    public Part(String name, Date dateOfPurchase) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getDateOfInstal() {
        return dateOfInstal;
    }

    public void setDateOfInstal(Date dateOfInstal) {
        this.dateOfInstal = dateOfInstal;
    }

    public boolean isInstaled() {
        return isInstaled;
    }

    public void setInstaled(boolean instaled) {
        isInstaled = instaled;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Long getMilage() {
        return milage;
    }

    public void setMilage(Long milage) {
        this.milage = milage;
    }
}
