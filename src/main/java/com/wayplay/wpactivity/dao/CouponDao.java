package com.wayplay.wpactivity.dao;

import java.util.Map;

import com.wayplay.wpactivity.model.Coupon;

public interface CouponDao {
	
	/**
	 * 随机抽出一张礼券
	 * 
	 * @return
	 */
	public Coupon findRandomCoupon();
	
	/**
	 * 更新礼券使用状态
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int updateCouponStatus(Map map);

}
