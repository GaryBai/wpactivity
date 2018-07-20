package com.wayplay.wpactivity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wayplay.wpactivity.model.Activity;
import com.wayplay.wpactivity.model.Cash;
import com.wayplay.wpactivity.model.Coupon;
import com.wayplay.wpactivity.model.QRCode;
import com.wayplay.wpactivity.model.QRCoupon;
import com.wayplay.wpactivity.model.Withdraw;
import com.wayplay.wpactivity.service.impl.ActivityServiceImpl;
import com.wayplay.wpactivity.service.impl.CashServiceImpl;
import com.wayplay.wpactivity.service.impl.CouponServiceImpl;
import com.wayplay.wpactivity.service.impl.QRCodeServiceImpl;
import com.wayplay.wpactivity.service.impl.QRCouponServiceImpl;
import com.wayplay.wpactivity.service.impl.WithdrawServiceImpl;

@RestController
public class ActivityController {
	

	@Resource
	private ActivityServiceImpl activityService;
	
	@Resource
	private WithdrawServiceImpl withdrawService;
	
	@Resource
	private CashServiceImpl cashService;
	
	@Resource
	private CouponServiceImpl couponService;
	
	@Resource
	private QRCodeServiceImpl qRCodeService;
	
	@Resource
	private QRCouponServiceImpl qRCouponService;
	
	@Value("${lottery.coupon.smallrate}")
	private double couponsmallrate;
	
	@Value("${lottery.coupon.mediumrate}")
	private double couponmediumrate;
	
	@Value("${lottery.coupon.largerate}")
	private double couponlargerate;
	
	@Value("${lottery.cash.smallrate}")
	private double cashsmallrate;
	
	@Value("${lottery.cash.mediumrate}")
	private double cashmediumrate;
	
	@Value("${lottery.cash.largerate}")
	private double cashlargerate;
	
	@Value("${lottery.cash.smallmax}")
	private int smallmax;
	
	@Value("${lottery.cash.mediummax}")
	private int mediummax;
	
	@Value("${lottery.cash.largemax}")
	private int largemax;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "This is wpactivity service";
	}
	
	@RequestMapping(value = "/activity", method = RequestMethod.POST)
	public Activity activity() {
		System.out.println("activity");
		return activityService.findCurActivity();
	}
	
	@RequestMapping(value = "/activity1", method = RequestMethod.GET)
	public Activity activity1() {
		System.out.println("activity1");
		return activityService.findCurActivity();
	}
	
	@RequestMapping(value = "/withdrawlist", method = RequestMethod.POST)
	public List<Map<String, String>> withdrawlist() {
		System.out.println("withdrawlist");
		return withdrawService.getLatestWithdrawList();
	}
	
	@RequestMapping(value = "/withdrawlist1", method = RequestMethod.GET)
	public List<Map<String, String>> withdrawlist1() {
		System.out.println("withdrawlist1");
		return withdrawService.getLatestWithdrawList();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/lottery", method = RequestMethod.POST)
	public <T> List<T> lottery(@RequestParam String type) {
		
		List<T> list = new ArrayList<T>();
		int num1 = (int) (Math.random() * 100);
		int num2 = (int) (Math.random() * 100);
		
		// 各档位礼券中奖率读取配置文件，中奖后随机抓取一条
		// 各档位现金券中奖率读取配置文件，中奖后随机生成不大于各档位最大值的现金
		
		if ("1".equalsIgnoreCase(type)) {
			if(num1 < couponsmallrate * 100) {
				System.out.println("礼券中奖");
				list.add((T)couponService.findRandomCoupon());
			}else {
				System.out.println("礼券未中奖");
				list.add(null);
			}
			if(num2 < cashsmallrate * 100) {
				System.out.println("现金券中奖");
				float value = (float)(Math.random() * smallmax);
				System.out.println(value);
				Cash cash = new Cash();
				cash.setName("现金券");
				cash.setStatus(0);
				cash.setUnit("元");
				cash.setValue(value);
				cashService.insertCash(cash);
				list.add((T) cash);
			}else {
				System.out.println("现金券未中奖");
				list.add(null);
			}
		} else if ("2".equalsIgnoreCase(type)) {
			if(num1 < cashmediumrate * 100) {
				System.out.println("礼券中奖");
				list.add((T)couponService.findRandomCoupon());
			}else {
				System.out.println("礼券未中奖");
				list.add(null);
			}
			if(num2 < cashmediumrate * 100) {
				System.out.println("现金券中奖");
				float value = (float)(Math.round((Math.random() * mediummax) * 100)) / 100;
				System.out.println(value);
				Cash cash = new Cash();
				cash.setName("现金券");
				cash.setStatus(0);
				cash.setUnit("元");
				cash.setValue(value);
				cashService.insertCash(cash);
				list.add((T) cash);
			}else {
				System.out.println("现金券未中奖");
				list.add(null);
			}
		} else if ("3".equalsIgnoreCase(type)) {
			if(num1 < couponlargerate * 100) {
				System.out.println("礼券中奖");
				list.add((T)couponService.findRandomCoupon());
			}else {
				System.out.println("礼券未中奖");
				list.add(null);
			}
			if(num2 < cashlargerate * 100) {
				System.out.println("现金券中奖");
				float value = (float)(Math.round((Math.random() * largemax) * 100)) / 100;
				System.out.println(value);
				Cash cash = new Cash();
				cash.setName("现金券");
				cash.setStatus(0);
				cash.setUnit("元");
				cash.setValue(value);
				cashService.insertCash(cash);
				list.add((T) cash);
			}else {
				System.out.println("现金券未中奖");
				list.add(null);
			}
		}
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/lottery1", method = RequestMethod.GET)
	public <T> List<T> lottery1(@RequestParam String type) {
		
		List<T> list = new ArrayList<T>();
		int num1 = (int) (Math.random() * 100);
		int num2 = (int) (Math.random() * 100);
		
		// 各档位礼券中奖率读取配置文件，中奖后随机抓取一条
		// 各档位现金券中奖率读取配置文件，中奖后随机生成不大于各档位最大值的现金
		
		if ("1".equalsIgnoreCase(type)) {
			if(num1 < couponsmallrate * 100) {
				System.out.println("礼券中奖");
				list.add((T)couponService.findRandomCoupon());
			}else {
				System.out.println("礼券未中奖");
				list.add(null);
			}
			if(num2 < cashsmallrate * 100) {
				System.out.println("现金券中奖");
				float value = (float)(Math.random() * smallmax);
				System.out.println(value);
				Cash cash = new Cash();
				cash.setName("现金券");
				cash.setStatus(0);
				cash.setUnit("元");
				cash.setValue(value);
				cashService.insertCash(cash);
				list.add((T) cash);
			}else {
				System.out.println("现金券未中奖");
				list.add(null);
			}
		} else if ("2".equalsIgnoreCase(type)) {
			if(num1 < cashmediumrate * 100) {
				System.out.println("礼券中奖");
				Coupon coupon = couponService.findRandomCoupon();
				list.add((T) coupon);
			}else {
				System.out.println("礼券未中奖");
				list.add(null);
			}
			if(num2 < cashmediumrate * 100) {
				System.out.println("现金券中奖");
				float value = (float)(Math.round((Math.random() * mediummax) * 100)) / 100;
				System.out.println(value);
				Cash cash = new Cash();
				cash.setName("现金券");
				cash.setStatus(0);
				cash.setUnit("元");
				cash.setValue(value);
				cashService.insertCash(cash);
				list.add((T) cash);
			}else {
				System.out.println("现金券未中奖");
				list.add(null);
			}
		} else if ("3".equalsIgnoreCase(type)) {
			if(num1 < couponlargerate * 100) {
				System.out.println("礼券中奖");
				list.add((T)couponService.findRandomCoupon());
			}else {
				System.out.println("礼券未中奖");
				list.add(null);
			}
			if(num2 < cashlargerate * 100) {
				System.out.println("现金券中奖");
				float value = (float)(Math.round((Math.random() * largemax) * 100)) / 100;
				System.out.println(value);
				Cash cash = new Cash();
				cash.setName("现金券");
				cash.setStatus(0);
				cash.setUnit("元");
				cash.setValue(value);
				cashService.insertCash(cash);
				list.add((T) cash);
			}else {
				System.out.println("现金券未中奖");
				list.add(null);
			}
		}
		return list;
	}
	
	/**
	 * 生成二维码id，插入二维码礼券现金券关联表
	 * 
	 * @param did 设备id
	 * @param cpIds	礼券id列表
	 * @param caIds	现金券id列表
	 * @return
	 */
	@RequestMapping(value = "/insertqrcode", method = RequestMethod.POST)
	public Long insertQRCode(@RequestParam Long did, @RequestParam Long[] cpIds, @RequestParam Long[] caIds) {
		System.out.println("insertQRCode");
		QRCode qRCode = new QRCode();
		qRCode.setDid(did);
		// 生成二维码id
		qRCodeService.insertQRCode(qRCode);
		Long qrid = qRCode.getQrid();
		
		// 插入二维码与礼券关联关系
		QRCoupon qRCoupon = new QRCoupon();
		for(Long cid : cpIds) {
			qRCoupon.setQrid(qrid);
			qRCoupon.setType(0);
			qRCoupon.setCid(cid);
			qRCouponService.insertQRCoupon(qRCoupon);
		}
		
		// 插入二维码与现金券关联关系
		for(Long cid : caIds) {
			qRCoupon.setQrid(qrid);
			qRCoupon.setType(1);
			qRCoupon.setCid(cid);
			qRCouponService.insertQRCoupon(qRCoupon);
		}
				
		return qrid;
	}
	
	/**
	 * 更新二维码url
	 * 
	 * @param qrid 二维码id
	 * @param url 二维码图片url
	 * @return
	 */
	@RequestMapping(value = "/updateqrcodeurl", method = RequestMethod.POST)
	public int updateqrcodeurl(@RequestParam Long qrid, @RequestParam String url) {
		System.out.println("updateqrcodeurl");	
		return qRCodeService.updateQRCodeUrl(qrid, url);
	}
	
	/**
	 * 插入提现记录
	 * 
	 * @param uid
	 * @param openid
	 * @param qrid
	 */
	@RequestMapping(value = "/insertwithdraw", method = RequestMethod.POST)
	public String insertWithdraw(@RequestParam Long uid, @RequestParam String openid, @RequestParam Long qrid) {
		System.out.println("insertwithdraw");
		String result = "1";
		Withdraw withdraw = new Withdraw();
		List<QRCoupon> qs = qRCouponService.findCouponListByQRid(qrid);
		// 更新二维码扫描状态
		qRCodeService.updateQRCodeStatus(qrid);
		try {
			for (QRCoupon i : qs) {
				withdraw.setUid(uid);
				withdraw.setOpenid(openid);
				withdraw.setCid(i.getCid());
				withdraw.setType(i.getType());
				withdrawService.insertWithdraw(withdraw);
				if(i.getType() == 0) {
					couponService.updateCouponStatus(i.getCid(), 2);
				}else if(i.getType() == 1) {
					cashService.updateCashStatus(i.getCid(), 1);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "-1";
		}
		return result;
	}
	
	/**
	 * 获取提现记录
	 * 
	 * @param openid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getwithdraw", method = RequestMethod.POST)
	public <T> List<T> getWithdraw(@RequestParam String openid){
		System.out.println("getwithdraw");
		List<T> list = new ArrayList<T>();
		list.add((T) withdrawService.getCouponWithdrawListByOpenid(openid));
		list.add((T) withdrawService.getCashWithdrawListByOpenid(openid));
		return list;
	}
	
	/**
	 * 获取提现记录
	 * 
	 * @param uid
	 * @param qrid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getwithdraw1", method = RequestMethod.GET)
	public <T> List<T> getWithdraw1(@RequestParam String openid){
		System.out.println("getwithdraw1");
		List<T> list = new ArrayList<T>();
		list.add((T) withdrawService.getCouponWithdrawListByOpenid(openid));
		list.add((T) withdrawService.getCashWithdrawListByOpenid(openid));
		return list;
	}
	
	
	
	/**
	 * 提现接口
	 * 
	 * @param uid
	 * @param qrid 非空为扫码打开，需要插入二维码关联表后获取列表，为空直接获取列表
	 * @return
	 *//*
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/withdraw1", method = RequestMethod.GET)
	public <T> List<T> withdraw1(@RequestParam Long uid, @RequestParam Long qrid){
		System.out.println("widthdraw");
		List<T> list = new ArrayList<T>();
		Withdraw withdraw = new Withdraw();
		if(null == qrid) {
			list.add((T) withdrawService.getCouponWithdrawList(uid));
			list.add((T) withdrawService.getCashWithdrawList(uid));
		}else {
			List<QRCoupon> q = qRCouponService.findCouponListByQRid(qrid);
			for (QRCoupon i : q) {
				withdraw.setUid(uid);
				withdraw.setCid(i.getCid());
				withdraw.setType(i.getType());
				withdrawService.insertWithdraw(withdraw);
			}
			list.add((T) withdrawService.getCouponWithdrawList(uid));
			list.add((T) withdrawService.getCashWithdrawList(uid));
		}
		return list;
	}*/
	
	/**
	 * 根据二维码id查询设备id
	 * 
	 * @param qrid
	 * @return
	 */
	@RequestMapping(value = "/finddidbyqrid", method = RequestMethod.POST)
	public Long findDidByQrid(@RequestParam Long qrid) {
		return null == qrid ? null :qRCodeService.findDidByQrid(qrid);
	}
	
	//@Value("${test}")
	private String ttt;
	
	@RequestMapping(value = "/ttt", method = RequestMethod.GET)
	public String ttt() {
		System.out.println("ttt");	
		return ttt;
	}

}
