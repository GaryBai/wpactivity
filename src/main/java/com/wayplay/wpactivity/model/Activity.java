package com.wayplay.wpactivity.model;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2015070568009988888L;

	private Long acid;

	private String content;

	private String homepicurl;

	private String actpicurl;

	private int prizes;

	private int prizem;

	private int prizel;

	private int status;

	private Date createtime;

	public Long getAcid() {
		return acid;
	}

	public void setAcid(Long acid) {
		this.acid = acid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHomepicurl() {
		return homepicurl;
	}

	public void setHomepicurl(String homepicurl) {
		this.homepicurl = homepicurl;
	}

	public String getActpicurl() {
		return actpicurl;
	}

	public void setActpicurl(String actpicurl) {
		this.actpicurl = actpicurl;
	}

	public int getPrizes() {
		return prizes;
	}

	public void setPrizes(int prizes) {
		this.prizes = prizes;
	}

	public int getPrizem() {
		return prizem;
	}

	public void setPrizem(int prizem) {
		this.prizem = prizem;
	}

	public int getPrizel() {
		return prizel;
	}

	public void setPrizel(int prizel) {
		this.prizel = prizel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Activity [acid=" + acid + ", content=" + content + ", homepicurl=" + homepicurl + ", actpicurl="
				+ actpicurl + ", prizes=" + prizes + ", prizem=" + prizem + ", prizel=" + prizel + ", status=" + status
				+ ", createtime=" + createtime + "]";
	}

}
