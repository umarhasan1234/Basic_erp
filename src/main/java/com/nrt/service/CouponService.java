package com.nrt.service;

import org.springframework.stereotype.Service;

import com.nrt.entity.Coupon;

@Service
public interface CouponService {

	public Boolean Register(Coupon coupon);

}
