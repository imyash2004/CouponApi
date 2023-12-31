package com.coupon.coupon.entities;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    private String couponCode;
    private String startDate;
    private String endDate;
    private int validityDays;
    private Boolean isPublic;



    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Date getStartDate() {
        return new Date(startDate);
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return new Date(endDate);
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getValidityDays() {
        return validityDays;
    }

    public void setValidityDays(int validityDays) {
        this.validityDays = validityDays;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Coupon( String couponCode, String startDate, String endDate, int validityDays, Boolean isPublic) {

        this.couponCode = couponCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.validityDays = validityDays;
        this.isPublic = isPublic;
    }

    public Coupon() {
    }
}
