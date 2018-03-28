package com.lanu.trucks_repair_shop.domain.vehicle;

import javax.persistence.*;

@Entity
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String typeOfVehicle;

    public Make(){}

    public Make(String name, String typeOfVehicle) {
        this.name = name;
        this.typeOfVehicle = typeOfVehicle;
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

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }
}
