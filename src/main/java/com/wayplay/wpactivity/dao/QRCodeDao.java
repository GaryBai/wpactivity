package com.wayplay.wpactivity.dao;

import java.util.Map;

import com.wayplay.wpactivity.model.QRCode;

public interface QRCodeDao {

	/**
	 * 插入一个二维码
	 * 
	 * @return
	 */
	public int insertQRCode(QRCode qRCode);

	/**
	 * 更新二维码图片url
	 * 
	 * @param qrid
	 * @param url
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int updateQRCodeUrl(Map map);
	
	/**
	 * 修改二维码扫描状态
	 * 
	 * @param qrid
	 * @return
	 */
	public int updateQRCodeStatus(Long qrid);
	
	/**
	 * 根据二维码id查询设备id
	 * 
	 * @param qrid
	 * @return
	 */
	public Long findDidByQrid(Long qrid);

}
