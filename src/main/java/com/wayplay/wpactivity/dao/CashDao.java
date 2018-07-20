package com.wayplay.wpactivity.dao;

import java.util.Map;

import com.wayplay.wpactivity.model.Cash;

public interface CashDao {
	
	/**
	 * 插入现金券记录
	 * 
	 * @return
	 */
	public int insertCash(Cash cash);
	
	/**
	 * 更新现金券使用状态
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int updateCashStatus(Map map);

}
