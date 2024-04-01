package com.example.demo.dto;

import java.util.Arrays;

import com.example.demo.entity.EmployeeAddress;

public class EmployeeDto {
	private int eId;
	private String eName;
	private String eDept;
	private Double esalary;
	private String estatus;
	private byte [] image;
	private EmployeeAddress employeeAddress;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteDept() {
		return eDept;
	}
	public void seteDept(String eDept) {
		this.eDept = eDept;
	}
	public Double getEsalary() {
		return esalary;
	}
	public void setEsalary(Double esalary) {
		this.esalary = esalary;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	public EmployeeDto(int eId, String eName, String eDept, Double esalary, String estatus, byte[] image,
			EmployeeAddress employeeAddress) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eDept = eDept;
		this.esalary = esalary;
		this.estatus = estatus;
		this.image = image;
		this.employeeAddress = employeeAddress;
	}
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeDto [eId=" + eId + ", eName=" + eName + ", eDept=" + eDept + ", esalary=" + esalary
				+ ", estatus=" + estatus + ", image=" + Arrays.toString(image) + ", employeeAddress=" + employeeAddress
				+ "]";
	}
	
	
	

}
