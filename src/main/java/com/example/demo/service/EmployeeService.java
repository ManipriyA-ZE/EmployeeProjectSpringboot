package com.example.demo.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.EmployeeTimeCard;

public interface EmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	public List<EmployeeDto> getAllEmployees();
	public EmployeeDto getById(int eId);
	public EmployeeDto updateEmployee(int eId,EmployeeDto employeeDto);
	public String deletEmployeeDetails(int eId);
	public String createEmployeeImage( MultipartFile file ,
			 String eName,  String eDept,Double esalary,
			 String estatus) throws IOException, SerialException, SQLException;
	public EmployeeTimeCard saveEmployeeTimeCard(EmployeeTimeCard employeeTimeCard);

	
}
