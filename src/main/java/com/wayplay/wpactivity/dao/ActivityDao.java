package com.wayplay.wpactivity.dao;

import com.wayplay.wpactivity.model.Activity;

public interface ActivityDao {
	
	/**
	 * 查询当前活动
	 * 
	 * @return
	 */
	public Activity findCurActivity();

}
