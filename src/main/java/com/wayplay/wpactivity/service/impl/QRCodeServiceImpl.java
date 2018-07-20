package com.wayplay.wpactivity.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayplay.wpactivity.dao.QRCodeDao;
import com.wayplay.wpactivity.model.QRCode;
import com.wayplay.wpactivity.service.IQRCodeService;

@Service("qRCodeService")
public class QRCodeServiceImpl implements IQRCodeService {
	
	@Resource
	private QRCodeDao qRCodeDao;

	@Override
	public int insertQRCode(QRCode qRCode) {
		// TODO Auto-generated method stub
		return qRCodeDao.insertQRCode(qRCode);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateQRCodeUrl(Long qrid, String url) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("qrid", qrid);
		map.put("url", url);
		return qRCodeDao.updateQRCodeUrl(map);
	}

	@Override
	public int updateQRCodeStatus(Long qrid) {
		// TODO Auto-generated method stub
		return qRCodeDao.updateQRCodeStatus(qrid);
	}

	@Override
	public Long findDidByQrid(Long qrid) {
		// TODO Auto-generated method stub
		return qRCodeDao.findDidByQrid(qrid);
	}

}
