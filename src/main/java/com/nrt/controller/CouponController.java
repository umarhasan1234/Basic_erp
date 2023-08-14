package com.nrt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.nrt.entity.Coupon;
import com.nrt.service.CouponService;

@Controller
public class CouponController {

	@Autowired
	private CouponService couponService;

	@GetMapping("/")
	public RedirectView CouponForm() {
		return new RedirectView("/html/coupon/coupon_register.html");

	}

	@PostMapping("/register")
	public RedirectView CouponRegister(@ModelAttribute("coupon") Coupon coupon) {
		
		Boolean flag = this.couponService.Register(coupon);
		
		return new RedirectView("/html/coupon/coupon_register.html");

	}

}
