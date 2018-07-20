package com.wayplay.wpactivity.dao;

import java.util.List;
import java.util.Map;

import com.wayplay.wpactivity.model.Withdraw;

public interface WithdrawDao {
	
	/**
	 * 查询最近中奖列表
	 * 
	 * @return
	 */
	public List<Map<String, String>> getLatestWithdrawList();
	
	/**
	 * 插入提现记录
	 * 
	 * @param withdraw
	 * @return
	 */
	public int insertWithdraw(Withdraw withdraw);
	
	/**
	 * 根据openid查询礼券中奖列表
	 * 
	 * @param openid
	 * @return
	 */
	public List<Map<String, String>> getCouponWithdrawListByOpenid(String openid);
	
	/**
	 * 根据openid查询现金券中奖列表
	 * 
	 * @param openid
	 * @return
	 */
	public List<Map<String, String>> getCashWithdrawListByOpenid(String openid);

}
