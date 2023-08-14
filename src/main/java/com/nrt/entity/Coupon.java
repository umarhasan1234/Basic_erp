package com.nrt.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "Coupon_Details")
@ToString
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long couponId;

	@Column(name = "coupon_code")
	private String couponCode;

	@Column(name = "coupon_type")
	private String couponType;

	@Column(name = "coupon_amount")
	private long couponAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	@Column(name = "created_at")
	private Date createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	@Column(name = "expires_at")
	private Date expiresAt;

}
