package com.wayplay.wpactivity.service;

import com.wayplay.wpactivity.model.Cash;

public interface ICashService {
	
	/**
	 * 插入现金券记录
	 * 
	 * @return
	 */
	public int insertCash(Cash cash);
	
	/**
	 * 更新现金券使用状态
	 * 
	 * @param caid
	 * @param status
	 * @return
	 */
	public int updateCashStatus(Long caid, int status);

}
