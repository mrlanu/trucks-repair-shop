package com.lanu.trucks_repair_shop.domain.breaking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BreakingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bdId;

    private String name;

    private String description;

    public BreakingDetail(){}

    public BreakingDetail(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getBdId() {
        return bdId;
    }

    public void setBdId(Integer bdId) {
        this.bdId = bdId;
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
}
