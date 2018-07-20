package com.wayplay.wpactivity.model;

import java.io.Serializable;
import java.util.Date;

public class Withdraw implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2860855895540090463L;

	private Long uid;

	private String openid;

	private int type;

	private Long cid;

	private Date receivetime;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Date getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}

	@Override
	public String toString() {
		return "Withdraw [uid=" + uid + ", openid=" + openid + ", type=" + type + ", cid=" + cid + ", receivetime="
				+ receivetime + "]";
	}

}
