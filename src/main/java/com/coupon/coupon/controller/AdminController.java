package com.coupon.coupon.controller;

import com.coupon.coupon.entities.Coupon;
import com.coupon.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private CouponService couponService;


    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons(){
        return this.couponService.getAllCoupons();
    }


    @GetMapping("/coupon/{code}")
    public Coupon getCoupon(@PathVariable String code){
        return this.couponService.getCouponById(code).orElseThrow(()->new RuntimeException("coupon does not found"));
    }


    @GetMapping("/deleteCoupon/{code}")
    public void deleteCoupon(@PathVariable String code){
        this.couponService.deleteCoupon(code);
    }


    @PostMapping("/create/")
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return this.couponService.createCoupon(coupon);
    }


    @PutMapping("/update/{code}")
    public Coupon updateCoupon( @PathVariable String code,@RequestBody Coupon coupon){
        return this.couponService.updateCoupon(code,coupon);
    }
}
