package com.lanu.trucks_repair_shop.domain;

import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    private String dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "vehicle_number")
    private Vehicle vehicle;

    private int milage;

    public Part(){}

    public Part(String name, String dateOfPurchase, int milage) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.milage = milage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }
}
