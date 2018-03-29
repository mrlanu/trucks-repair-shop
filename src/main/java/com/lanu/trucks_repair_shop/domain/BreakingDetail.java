package com.lanu.trucks_repair_shop.domain;

import com.lanu.trucks_repair_shop.domain.security.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BreakingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String detail;

    private boolean fixed;

    private Date dateFixed;

    @OneToOne
    private User mechanic;

    @ManyToOne
    private Breaking breaking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public Date getDateFixed() {
        return dateFixed;
    }

    public void setDateFixed(Date dateFixed) {
        this.dateFixed = dateFixed;
    }

    public User getMechanic() {
        return mechanic;
    }

    public void setMechanic(User mechanic) {
        this.mechanic = mechanic;
    }

    public Breaking getBreaking() {
        return breaking;
    }

    public void setBreaking(Breaking breaking) {
        this.breaking = breaking;
    }
}
