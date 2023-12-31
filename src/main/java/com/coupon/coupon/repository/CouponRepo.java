package com.coupon.coupon.repository;

import com.coupon.coupon.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon,String> {
}
