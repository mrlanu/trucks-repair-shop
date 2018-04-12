package com.lanu.trucks_repair_shop.domain.breaking;

import com.lanu.trucks_repair_shop.domain.security.Users;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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

    @Digits(integer = 2000000, fraction = 0)
    private String vehicleMilage;
    private boolean fixed;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "vehicle_number")
    private Vehicle vehicle;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "breaking_id")
    private List<BreakingDetail> breakingDetailList;

    @OneToOne
    private Users userCreate;

    @OneToOne
    private Users userFixing;

    public Breaking(){}

    public Breaking(Date dateCreate, String vehicleMilage) {
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

    public String getVehicleMilage() {
        return vehicleMilage;
    }

    public void setVehicleMilage(String vehicleMilage) {
        this.vehicleMilage = vehicleMilage;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public Users getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Users userCreate) {
        this.userCreate = userCreate;
    }

    public Users getUserFixing() {
        return userFixing;
    }

    public void setUserFixing(Users userFixing) {
        this.userFixing = userFixing;
    }

    public List<BreakingDetail> getBreakingDetailList() {
        return breakingDetailList;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
