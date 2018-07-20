package com.wayplay.wpactivity.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayplay.wpactivity.dao.WithdrawDao;
import com.wayplay.wpactivity.model.Withdraw;
import com.wayplay.wpactivity.service.IWithdrawService;

@Service("withdrawService")
public class WithdrawServiceImpl implements IWithdrawService {
	
	@Resource
	private WithdrawDao withdrawDao;

	@Override
	public List<Map<String, String>> getLatestWithdrawList() {
		// TODO Auto-generated method stub
		return withdrawDao.getLatestWithdrawList();
	}

	@Override
	public int insertWithdraw(Withdraw withdraw) {
		// TODO Auto-generated method stub
		return withdrawDao.insertWithdraw(withdraw);
	}

	@Override
	public List<Map<String, String>> getCouponWithdrawListByOpenid(String openid) {
		// TODO Auto-generated method stub
		return withdrawDao.getCouponWithdrawListByOpenid(openid);
	}

	@Override
	public List<Map<String, String>> getCashWithdrawListByOpenid(String openid) {
		// TODO Auto-generated method stub
		return withdrawDao.getCashWithdrawListByOpenid(openid);
	}


}
