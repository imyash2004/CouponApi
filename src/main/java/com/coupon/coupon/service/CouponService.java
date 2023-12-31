package com.coupon.coupon.service;

import com.coupon.coupon.entities.Coupon;
import com.coupon.coupon.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {
    @Autowired
    private CouponRepo couponRepo;
    public Coupon createCoupon(Coupon coupon){
        return this.couponRepo.save(coupon);
    }
    public Optional<Coupon> getCouponById(String couponId){
        return this.couponRepo.findById(couponId);
    }
    public List<Coupon> getAllCoupons(){
        return this.couponRepo.findAll();
    }
    public Coupon updateCoupon(String couponId,Coupon coupon){
        if(couponRepo.existsById(couponId)){
            return this.couponRepo.save(coupon);
        }
        else {
            throw new RuntimeException("coupon doesnot found");
        }
    }
    public void deleteCoupon(String couponID){
        this.couponRepo.deleteById(couponID);
    }

}
