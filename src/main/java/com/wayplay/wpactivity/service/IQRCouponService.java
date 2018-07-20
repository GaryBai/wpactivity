package com.wayplay.wpactivity.service;

import java.util.List;

import com.wayplay.wpactivity.model.QRCoupon;

public interface IQRCouponService {
	
	/**
	 * 插入一个二维码礼券现金券关联关系
	 * 
	 * @return
	 */
	public int insertQRCoupon(QRCoupon qRCoupon);
	
	/**
	 * 根据二维码id查询礼券现金券
	 * 
	 * @param qrid
	 * @return
	 */
	public List<QRCoupon> findCouponListByQRid(Long qrid);

}
