package com.nrt.util;

public class MasterEnum {

	public enum DiscountType {
		FLAT(1), PERCENT(2);

		private Integer discountId;

		private DiscountType(Integer discountId) {
			this.discountId = discountId;
		}

		public Integer getDiscountId() {
			return this.discountId;
		}

		public static DiscountType getById(int discountId) {
			for (DiscountType n : values()) {
				if (n.discountId == (discountId))
					return n;
			}
			return null;
		}
	}

}
