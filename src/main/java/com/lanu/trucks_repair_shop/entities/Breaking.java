package com.lanu.trucks_repair_shop.entities;

import java.util.Date;
import java.util.List;

public class Breaking {

    private Long id;
    private Date date;
    private Long milage;
    private List<FixProblem> fixProblemList;

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

    public List<FixProblem> getFixProblemList() {
        return fixProblemList;
    }

    public void setFixProblemList(List<FixProblem> fixProblemList) {
        this.fixProblemList = fixProblemList;
    }
}
