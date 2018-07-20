package com.wayplay.wpactivity.model;

import java.io.Serializable;
import java.util.Date;

public class Coupon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6576094181270990872L;

	private Long cpid;

	private String oid;

	private String name;

	private String desc;

	private String period;

	private int status;

	private String value;

	private String unit;

	private Date createtime;

	private Date issuetime;

	private Date receivetime;

	public Long getCpid() {
		return cpid;
	}

	public void setCpid(Long cpid) {
		this.cpid = cpid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(Date issuetime) {
		this.issuetime = issuetime;
	}

	public Date getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}

	@Override
	public String toString() {
		return "Coupon [cpid=" + cpid + ", oid=" + oid + ", name=" + name + ", desc=" + desc + ", period=" + period
				+ ", status=" + status + ", value=" + value + ", unit=" + unit + ", createtime=" + createtime
				+ ", issuetime=" + issuetime + ", receivetime=" + receivetime + "]";
	}

}
