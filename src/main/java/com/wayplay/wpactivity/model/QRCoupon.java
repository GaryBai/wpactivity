package com.wayplay.wpactivity.model;

import java.io.Serializable;

public class QRCoupon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5188819456294088481L;

	private Long qrid;

	private int type;

	private Long cid;

	public Long getQrid() {
		return qrid;
	}

	public void setQrid(Long qrid) {
		this.qrid = qrid;
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

	@Override
	public String toString() {
		return "QRCoupon [qrid=" + qrid + ", type=" + type + ", cid=" + cid + "]";
	}

}
