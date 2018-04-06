package com.lanu.trucks_repair_shop.domain.breaking;

import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Breaking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer breakingId;

    private Date dateCreate;
    private Date dateFixed;
    private int vehicleMilage;
    private boolean fixed;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "breaking_id")
    private List<BreakingDetail> breakingDetailList;

    @OneToOne
    private User userCreate;

    @OneToOne
    private User userFixing;

    public Breaking(){}

    public Breaking(Date dateCreate, int vehicleMilage) {
        this.dateCreate = dateCreate;
        this.vehicleMilage = vehicleMilage;
    }

    public Integer getBreakingId() {
        return breakingId;
    }

    public void setBreakingId(Integer breakingId) {
        this.breakingId = breakingId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateFixed() {
        return dateFixed;
    }

    public void setDateFixed(Date dateFixed) {
        this.dateFixed = dateFixed;
    }

    public int getVehicleMilage() {
        return vehicleMilage;
    }

    public void setVehicleMilage(int vehicleMilage) {
        this.vehicleMilage = vehicleMilage;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public User getUserFixing() {
        return userFixing;
    }

    public void setUserFixing(User userFixing) {
        this.userFixing = userFixing;
    }

    public List<BreakingDetail> getBreakingDetailList() {
        return breakingDetailList;
    }

    public void setBreakingDetailList(List<BreakingDetail> breakingDetailList) {
        this.breakingDetailList = breakingDetailList;
    }

    public void addBreakingDetail(BreakingDetail breakingDetail){
        if (breakingDetailList == null){
            breakingDetailList = new ArrayList<>();
        }
        breakingDetailList.add(breakingDetail);
    }

}
