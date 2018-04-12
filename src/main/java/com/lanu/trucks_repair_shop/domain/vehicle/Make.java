package com.lanu.trucks_repair_shop.domain.vehicle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer makeId;

    private String name;

    private String typeOfVehicle;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "make_id")
    private List<Model> modelList;

    public Make(){}

    public Make(String name, String typeOfVehicle) {
        this.name = name;
        this.typeOfVehicle = typeOfVehicle;
    }

    public Integer getMakeId() {
        return makeId;
    }

    public void setMakeId(Integer makeId) {
        this.makeId = makeId;
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

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    public void addModel(Model model){
        if (modelList == null){
            modelList = new ArrayList<>();
        }
        modelList.add(model);
    }
}
