package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class EmployeeTimeCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eId;
	private String eName;
	private LocalDate date;
	private LocalTime checkIn;
	private LocalTime CheckOut;
	private String shiftType;
	private String shiftHours;
	private String DialyWorkingHours;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalTime checkIn) {
		this.checkIn = checkIn;
	}
	public LocalTime getCheckOut() {
		return CheckOut;
	}
	public void setCheckOut(LocalTime checkOut) {
		CheckOut = checkOut;
	}
	public String getShiftType() {
		return shiftType;
	}
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}
	public String getShiftHours() {
		return shiftHours;
	}
	public void setShiftHours(String shiftHours) {
		this.shiftHours = shiftHours;
	}
	public String getDialyWorkingHours() {
		return DialyWorkingHours;
	}
	public void setDialyWorkingHours(String dialyWorkingHours) {
		DialyWorkingHours = dialyWorkingHours;
	}
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public EmployeeTimeCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeTimeCard(int eId, String eName, LocalDate date, LocalTime checkIn, LocalTime checkOut,
			String shiftType, String shiftHours, String dialyWorkingHours) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.date = date;
		this.checkIn = checkIn;
		CheckOut = checkOut;
		this.shiftType = shiftType;
		this.shiftHours = shiftHours;
		DialyWorkingHours = dialyWorkingHours;
	}
	@Override
	public String toString() {
		return "EmployeeTimeCard [eId=" + eId + ", eName=" + eName + ", date=" + date + ", checkIn=" + checkIn
				+ ", CheckOut=" + CheckOut + ", shiftType=" + shiftType + ", shiftHours=" + shiftHours
				+ ", DialyWorkingHours=" + DialyWorkingHours + "]";
	}
	
	
	
	

}
