package com.nrt.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrt.entity.Coupon;
import com.nrt.repository.CouponRepository;
import com.nrt.request.CouponRequest;
import com.nrt.service.CouponService;
import com.nrt.util.MasterEnum.DiscountType;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Boolean Register(CouponRequest couponRequest) {
		Coupon coupon = new Coupon();
		if (couponRequest.getCouponId() != 0) {
			coupon.setCouponId(couponRequest.getCouponId());
		}
		coupon.setActivetAt(couponRequest.getCouponActivetAt());
		coupon.setAmount(couponRequest.getCouponAmount());
		coupon.setApplyPerUser(couponRequest.getCouponApplyPerUser());
		coupon.setCode(couponRequest.getCouponCode());
		coupon.setCreatedAt(LocalDate.now());
		coupon.setDescription(couponRequest.getCouponDescription());
		coupon.setExpiresAt(couponRequest.getCouponExpiresAt());
		coupon.setIfAmountAbove(couponRequest.getCouponIfAmountAbove());
		coupon.setType(DiscountType.getById(couponRequest.getCouponType()));
		try {
			couponRepository.save(coupon);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}

	}

	@Override
	public CouponRequest getCouponById(Long couponId) {
		Optional<Coupon> couponOptional = couponRepository.findById(couponId);
		if (couponOptional.isPresent()) {
			CouponRequest couponRequest = new CouponRequest();
			Coupon coupon = couponOptional.get();
			couponRequest.setCouponActivetAt(coupon.getActivetAt());
			couponRequest.setCouponAmount(couponRequest.getCouponAmount());
			couponRequest.setCouponApplyPerUser(coupon.getApplyPerUser());
			couponRequest.setCouponCode(coupon.getCode());
			couponRequest.setCouponDescription(coupon.getDescription());
			couponRequest.setCouponExpiresAt(coupon.getExpiresAt());
			couponRequest.setCouponId(coupon.getCouponId());
			couponRequest.setCouponType(coupon.getType() == DiscountType.FLAT ? 1 : 2);
			couponRequest.setCouponIfAmountAbove(coupon.getIfAmountAbove());
			return couponRequest;
		} else {
			return null;
		}
	}

	@Override
	public Boolean Delete(long couponId) {
		try {
			couponRepository.deleteById(couponId);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}

	}

	@Override
	public List<Coupon> FindAllCoupon() {

		return couponRepository.findAll();
	}
}
