package com.wayplay.wpactivity.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayplay.wpactivity.dao.ActivityDao;
import com.wayplay.wpactivity.model.Activity;
import com.wayplay.wpactivity.service.IActivityService;

@Service("activityService")
public class ActivityServiceImpl implements IActivityService {

	@Resource
	private ActivityDao activityDao;
	
	@Override
	public Activity findCurActivity() {
		// TODO Auto-generated method stub
		return activityDao.findCurActivity();
	}

}
