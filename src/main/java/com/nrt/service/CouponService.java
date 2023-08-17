package com.nrt.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nrt.entity.Coupon;
import com.nrt.request.CouponRequest;

@Component
public interface CouponService {

	public Boolean Register(CouponRequest couponRequest);

	public CouponRequest getCouponById(Long couponId);

	public Boolean Delete(long couponId);

	public List<Coupon> FindAllCoupon();

}
