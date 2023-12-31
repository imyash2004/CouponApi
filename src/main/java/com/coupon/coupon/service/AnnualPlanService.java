package com.coupon.coupon.service;

import com.coupon.coupon.entities.Coupon;
import com.coupon.coupon.entities.User;
import com.coupon.coupon.repository.CouponRepo;
import com.coupon.coupon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnnualPlanService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CouponService couponService;
    public List<Coupon> getAllCoupons(User user){
        List<Coupon> list=this.couponRepo.findAll();
        List<Coupon> userList = new ArrayList<>();

        if (couponRepo.existsById(user.getUserId())){
           User user1=this.userRepo.getById(user.getUserId());
           if(user1.getRole().equals("Admin")){
               return list;
           }
        }
        if(!couponRepo.existsById(user.getUserId())){
            user.setRole("User");
            LocalDate date = LocalDate.now();
            user.setLogindate(date.toString());
            this.userRepo.save(user);}
        User user1=this.userRepo.getById(user.getUserId());

        for(Coupon coupon:list){
                if(coupon.getEndDate().after(user1.getLogindate()) &&
                        coupon.getStartDate().before(user1.getLogindate())
                        && coupon.getPublic()){
                    userList.add(coupon);

                }
            }
            return userList;
        }
        public void applyCoupon(String userId,String couponId){
            Coupon coupon=this.couponRepo.getById(couponId);
            User user=this.userRepo.getById(userId);
            if(!user.isApplied()){
                user.setApplied(true);
                user.setCoupId(couponId);

            }

        }
    }


