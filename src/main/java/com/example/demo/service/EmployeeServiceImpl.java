package com.example.demo.service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.EmployeeTimeCard;
import com.example.demo.repo.EmployeeTimeCardRepo;
import com.example.demo.repo.EmpoyeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService  {
	@Autowired
	EmpoyeeRepo empoyeeRepo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	EmployeeTimeCardRepo employeeTimeCardRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		EmployeeEntity emp=this.modelMapper.map(employeeDto, EmployeeEntity.class);
		emp=empoyeeRepo.save(emp);
		EmployeeDto empDto=this.modelMapper.map(emp, EmployeeDto.class);
		return empDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeEntity> empEntity=empoyeeRepo.findAll();
		List<EmployeeDto> empDto=new ArrayList<>();
		for(EmployeeEntity empList:empEntity) {
			if(empList.getEstatus().equals("Active")) {
				EmployeeDto eDto=this.modelMapper.map(empList,EmployeeDto.class);
				empDto.add(eDto);
				
			}
			
		}
		
		
		return empDto;
	}

	@Override
	public EmployeeDto getById(int eId) {
		Optional<EmployeeEntity> optional = empoyeeRepo.findById(eId);
		if(optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			EmployeeDto edto=this.modelMapper.map(employeeEntity, EmployeeDto.class);
			return edto;
		}
		
		return null;
	}

	@Override
	public EmployeeDto updateEmployee(int eId, EmployeeDto employeeDto) {
		Optional<EmployeeEntity> optional = empoyeeRepo.findById(eId);
		EmployeeEntity map = this.modelMapper.map(employeeDto, EmployeeEntity.class);
		if(optional.isPresent()) {
			optional.get().seteName(map.geteName());
			optional.get().seteDept(map.geteDept());
			optional.get().setEsalary(map.getEsalary());
			optional.get().setEstatus(map.getEstatus());
			EmployeeDto dto = this.modelMapper.map(map, EmployeeDto.class);
			return dto;
			
		}
		
		return null;
	}

	@Override
	public String deletEmployeeDetails(int eId) {
		Optional<EmployeeEntity> optional = empoyeeRepo.findById(eId);
		if(optional.isPresent()) {
			//empoyeeRepo.deleteById(eId);
			optional.get().setEstatus("In Active");
			
			return "deleted";
			
		}
		return "notDeleted";
	}

	

	@Override
	public String createEmployeeImage(MultipartFile file, String eName, String eDept, Double esalary, String estatus) throws IOException, SerialException, SQLException {
		EmployeeDto employeeDto=new EmployeeDto();
		EmployeeEntity employeeEntity = this.modelMapper.map(employeeDto, EmployeeEntity.class);
		employeeEntity.seteName(eName);
		employeeEntity.seteDept(eDept);
		employeeEntity.setEsalary(esalary);
		employeeEntity.setEstatus(estatus);
		Blob blob=new javax.sql.rowset.serial.SerialBlob(file.getBytes());
		employeeEntity.setImage(blob);
		empoyeeRepo.save(employeeEntity);
		
		
		return "imageSaved";
	}

	@Override
	public EmployeeTimeCard saveEmployeeTimeCard(EmployeeTimeCard employeeTimeCard) {
		employeeTimeCard.setDate(LocalDate.now());
		employeeTimeCard.setCheckIn(LocalTime.now());
		employeeTimeCard.setCheckOut(LocalTime.now().plusHours(8));
		Duration d=Duration.between(LocalTime.now(), LocalTime.now().plusHours(8));
		//employeeTimeCard.setDialyWorkingHours(String.valueOf(d));
		employeeTimeCard.setDialyWorkingHours( dialyWorkingHours(d));
		
		if(employeeTimeCard.getShiftType().equals("A")) {
			employeeTimeCard.setShiftHours("8");
		}else if(employeeTimeCard.getShiftType().equals("B")) {
			employeeTimeCard.setShiftHours("9");
		}else {
			employeeTimeCard.setShiftHours("10");
		}
		employeeTimeCardRepo.save(employeeTimeCard);
		
		
		return employeeTimeCard;
	}
	public static String dialyWorkingHours(Duration d) {
		long hours = d.toHours();
		long minutes = d.toMinutes()%60;
		return   hours+" hours"+" "+minutes+" minutes";
		
	} 

}
