package com.wayplay.wpactivity.model;

import java.io.Serializable;
import java.util.Date;

public class Cash implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4530464249062195462L;

	private Long caid;

	private String name;

	private int status;

	private float value;

	private String unit;

	private Date issuetime;

	private Date receivetime;

	public Long getCaid() {
		return caid;
	}

	public void setCaid(Long caid) {
		this.caid = caid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getValue() {
		return (float) (Math.round(value * 100)) / 100;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
		return "Cash [caid=" + caid + ", name=" + name + ", status=" + status + ", value=" + value + ", unit=" + unit
				+ ", issuetime=" + issuetime + ", receivetime=" + receivetime + "]";
	}

}
