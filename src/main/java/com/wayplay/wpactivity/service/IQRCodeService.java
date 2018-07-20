package com.wayplay.wpactivity.service;

import com.wayplay.wpactivity.model.QRCode;

public interface IQRCodeService {
	
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
	public int updateQRCodeUrl(Long qrid, String url);
	
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
