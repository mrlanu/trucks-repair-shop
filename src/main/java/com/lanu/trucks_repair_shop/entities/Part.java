package com.lanu.trucks_repair_shop.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    private String dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "unit_vinNumber")
    private Unit unit;

    private Long milage;

    public Part(){}

    public Part(String name, String dateOfPurchase, Unit unit, Long milage) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.unit = unit;
        this.milage = milage;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getMilage() {
        return milage;
    }

    public void setMilage(Long milage) {
        this.milage = milage;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", unit=" + unit.getVinNumber() +
                ", milage=" + milage +
                '}';
    }
}
