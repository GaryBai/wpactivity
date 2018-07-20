package com.wayplay.wpactivity.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayplay.wpactivity.dao.CashDao;
import com.wayplay.wpactivity.model.Cash;
import com.wayplay.wpactivity.service.ICashService;

@Service("cashService")
public class CashServiceImpl implements ICashService {
	
	@Resource
	private CashDao cashDao;

	@Override
	public int insertCash(Cash cash) {
		// TODO Auto-generated method stub
		return cashDao.insertCash(cash);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateCashStatus(Long caid, int status) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("caid", caid);
		map.put("status", status);
		return cashDao.updateCashStatus(map);
	}

}
