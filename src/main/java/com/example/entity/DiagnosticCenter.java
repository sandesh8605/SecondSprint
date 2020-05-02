package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Diagnostic Data")
public class DiagnosticCenter
{
	@Id
	private int id;
	private String centerName;
	private long contactNumber;
	private String Address;
	public String getCenterName() {
		return centerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	

	
	
}