package com.lanu.trucks_repair_shop.entities;

public class FixProblem {

    private Long id;
    private String name;
    private String description;
    private Breaking breaking;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Breaking getBreaking() {
        return breaking;
    }

    public void setBreaking(Breaking breaking) {
        this.breaking = breaking;
    }
}
