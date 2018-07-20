package com.wayplay.wpactivity.service;

import com.wayplay.wpactivity.model.Activity;

public interface IActivityService {
	
	/**
	 * 查询当前活动
	 * 
	 * @return
	 */
	public Activity findCurActivity();

}
