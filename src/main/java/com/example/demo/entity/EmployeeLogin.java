package com.example.demo.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeLogin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eId;
	private int year;
	private int month;
	private int date;
	private int hours;
	private int minutes;
	private int sec;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public EmployeeLogin(int year, int month, int date, int hours, int minutes, int sec) {
		super();
		this.year = year;
		this.month = month;
		this.date = date;
		this.hours = hours;
		this.minutes = minutes;
		this.sec = sec;
	}
	public EmployeeLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalTime logInTime( int hours, int minutes, int sec) {
		return LocalTime.of(hours, minutes, sec);
		
	}
	public LocalTime logOutTime( int hours, int minutes, int sec) {
		return LocalTime.of(hours, minutes, sec);
		
	}
	public Duration totalWorkingHours( LocalTime logInTime,LocalTime logOutTime) {
		return Duration.between(logInTime, logOutTime);
		
		
	}
	public LocalDate LoginDate(int year,int months,int date) {
		return LocalDate.of(year, months,date );
	}
	@Override
	public String toString() {
		return "EmployeeLogin [year=" + year + ", month=" + month + ", date=" + date + ", hours=" + hours + ", minutes="
				+ minutes + ", sec=" + sec + "]";
	}
	

}
