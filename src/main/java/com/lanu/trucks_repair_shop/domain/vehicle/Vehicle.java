package com.lanu.trucks_repair_shop.domain.vehicle;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
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

    @OneToOne
    private Make make;

    @OneToOne
    private Model model;

    @Pattern(regexp = "^\\d{4}$")
    private String year;

    private boolean isBroken;

    @OneToMany(mappedBy = "vehicle",
                fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH, CascadeType.MERGE,
                            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Breaking> breakingList;

    public Vehicle(){}

    public Vehicle(String type) {
        this.type = type;
    }

    public Vehicle(Integer number, String vinNumber, String type, String year) {
        this.number = number;
        this.vinNumber = vinNumber;
        this.type = type;
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

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
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

    public List<Breaking> getBreakingList() {
        return breakingList;
    }

    public void setBreakingList(List<Breaking> breakingList) {
        this.breakingList = breakingList;
    }

    public void addBreaking(Breaking breaking){
        if (breakingList == null){
            breakingList = new ArrayList<>();
        }
        breakingList.add(breaking);
        breaking.setVehicle(this);
    }
}
