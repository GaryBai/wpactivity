package com.wayplay.wpactivity.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayplay.wpactivity.dao.CouponDao;
import com.wayplay.wpactivity.model.Coupon;
import com.wayplay.wpactivity.service.ICouponService;

@Service("couponService")
public class CouponServiceImpl implements ICouponService {

	@Resource
	private CouponDao couponDao;
	
	@Override
	public Coupon findRandomCoupon() {
		// TODO Auto-generated method stub
		return couponDao.findRandomCoupon();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateCouponStatus(Long cpid, int status) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("cpid", cpid);
		map.put("status", status);
		return couponDao.updateCouponStatus(map);
	}

}
