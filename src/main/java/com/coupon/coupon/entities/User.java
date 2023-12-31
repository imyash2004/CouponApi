package com.coupon.coupon.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    private String userId;
    private String logindate;
    private String role;
    private boolean applied;
    private String coupId;

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }

    public String getCoupId() {
        return coupId;
    }

    public void setCoupId(String coupId) {
        this.coupId = coupId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLogindate() {
        return new Date(logindate);
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    public User(String userId, String logindate, String role) {
        this.userId = userId;
        this.logindate = logindate;
        this.role = role;
    }

    public User() {
    }
}



//    List<Coupon> list=this.couponRepo.findAll();
//    List<Coupon> userList = new ArrayList<>();
//        for(Coupon coupon:list){
//                if(coupon.getEndDate().after(user.getLogindate()) &&
//                coupon.getStartDate().before(user.getLogindate())
//                && coupon.getPublic()){
//                userList.add(coupon);
//
//                }
//                }
//                return userList;
//
