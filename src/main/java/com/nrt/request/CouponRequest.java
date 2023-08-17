package com.nrt.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CouponRequest {

	private long couponId;

	private String couponCode;

	private int couponType;

	private long couponAmount;

	private Date couponExpiresAt;

	private Date couponActivetAt;

	private long couponIfAmountAbove;

	private String couponDescription;

	private long couponApplyPerUser;

}
