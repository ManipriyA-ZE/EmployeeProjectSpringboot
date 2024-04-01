package com.example.demo.entity;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;

@Entity

public class EmployeeAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long addressId;
	private String addressCity;
	private String addressPincode;
	/*@ManyToOne
	@JoinColumn
	private EmployeeEntity employeeEntity;*/
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(String addressPincode) {
		this.addressPincode = addressPincode;
	}
	
	/*public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}
	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}*/
	/*public EmployeeAddress(long addressId, String addressCity, String addressPincode) {
		super();
		this.addressId = addressId;
		this.addressCity = addressCity;
		this.addressPincode = addressPincode;
	}*/
	
	public EmployeeAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeAddress(long addressId, String addressCity, String addressPincode) {
		super();
		this.addressId = addressId;
		this.addressCity = addressCity;
		this.addressPincode = addressPincode;
		
	}
	@Override
	public String toString() {
		return "EmployeeAddress [addressId=" + addressId + ", addressCity=" + addressCity + ", addressPincode="
				+ addressPincode + "]";
	}
	/*@Override
	public String toString() {
		return "EmployeeAddress [addressId=" + addressId + ", addressCity=" + addressCity + ", addressPincode="
				+ addressPincode + ", employeeEntity=" + employeeEntity + "]";
	}*/
	
	

}
