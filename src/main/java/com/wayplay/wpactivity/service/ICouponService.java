package com.wayplay.wpactivity.service;

import com.wayplay.wpactivity.model.Coupon;

public interface ICouponService {
	
	/**
	 * 随机抽出一张礼券
	 * 
	 * @return
	 */
	public Coupon findRandomCoupon();
	
	/**
	 * 更新礼券使用状态
	 * 
	 * @param cpid
	 * @param status
	 * @return
	 */
	public int updateCouponStatus(Long cpid, int status);

}
