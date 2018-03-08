package com.lanu.trucks_repair_shop.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Breaking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Long milage;

    @ManyToOne
    @JoinColumn(name = "unit_vinNumber")
    private Unit unit;

    public Breaking(){}

    public Breaking(Date date, Long milage, Unit unit) {
        this.date = date;
        this.milage = milage;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getMilage() {
        return milage;
    }

    public void setMilage(Long milage) {
        this.milage = milage;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
