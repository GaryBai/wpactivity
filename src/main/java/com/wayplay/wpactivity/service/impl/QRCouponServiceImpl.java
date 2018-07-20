package com.wayplay.wpactivity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayplay.wpactivity.dao.QRCouponDao;
import com.wayplay.wpactivity.model.QRCoupon;
import com.wayplay.wpactivity.service.IQRCouponService;

@Service("qRCouponService")
public class QRCouponServiceImpl implements IQRCouponService {

	@Resource
	private QRCouponDao qRCouponDao;
	
	@Override
	public int insertQRCoupon(QRCoupon qRCoupon) {
		// TODO Auto-generated method stub
		return qRCouponDao.insertQRCoupon(qRCoupon);
	}

	@Override
	public List<QRCoupon> findCouponListByQRid(Long qrid) {
		// TODO Auto-generated method stub
		return qRCouponDao.findCouponListByQRid(qrid);
	}

}
