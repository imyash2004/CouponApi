package com.coupon.coupon.repository;

import com.coupon.coupon.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
