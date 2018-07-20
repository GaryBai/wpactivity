package com.wayplay.wpactivity.model;

import java.io.Serializable;
import java.util.Date;

public class QRCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 818414414295469678L;

	private Long qrid;

	private String url;

	private Date createtime;

	private Date scantime;

	private Long did;

	private int status;

	public Long getQrid() {
		return qrid;
	}

	public void setQrid(Long qrid) {
		this.qrid = qrid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getScantime() {
		return scantime;
	}

	public void setScantime(Date scantime) {
		this.scantime = scantime;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "QRCode [qrid=" + qrid + ", url=" + url + ", createtime=" + createtime + ", scantime=" + scantime
				+ ", did=" + did + ", status=" + status + "]";
	}

}
