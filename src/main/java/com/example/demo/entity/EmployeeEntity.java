package com.example.demo.entity;

import java.sql.Blob;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;

@Entity

public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eId;
	@Column
	private String eName;
	@Column
	private String eDept;
	@Column
	private Double esalary;
	@Column
	private String estatus;
	@Lob
	private Blob image;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private EmployeeAddress employeeAddress;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private EmployeeLogin employeeLogin;
	/*@JsonIgnore
	@OneToMany(mappedBy="employeeEntity",cascade=CascadeType.ALL)
	private List<EmployeeAddress> employeeAddress;*/
	
	public EmployeeLogin getEmployeeLogin() {
		return employeeLogin;
	}
	public void setEmployeeLogin(EmployeeLogin employeeLogin) {
		this.employeeLogin = employeeLogin;
	}
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
	
	
	
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public List<EmployeeAddress> getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(List<EmployeeAddress> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}*/
	
	@Override
	public String toString() {
		return "EmployeeEntity [eId=" + eId + ", eName=" + eName + ", eDept=" + eDept + ", esalary=" + esalary
				+ ", estatus=" + estatus + ", image=" + image + ", employeeAddress=" + employeeAddress
				+ ", employeeLogin=" + employeeLogin + "]";
	}
	public EmployeeEntity(int eId, String eName, String eDept, Double esalary, String estatus, Blob image,
			EmployeeAddress employeeAddress, EmployeeLogin employeeLogin) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eDept = eDept;
		this.esalary = esalary;
		this.estatus = estatus;
		this.image = image;
		this.employeeAddress = employeeAddress;
		this.employeeLogin = employeeLogin;
	}
	
	
	
	
	
	
	
	
	
	
	

}
