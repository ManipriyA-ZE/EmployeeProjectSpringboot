package com.example.demo.Controller;


import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.modelmapper.internal.bytebuddy.asm.Advice.OffsetMapping.Sort;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.EmployeeLogin;
import com.example.demo.entity.EmployeeTimeCard;
import com.example.demo.repo.EmployeeLoginRepo;
import com.example.demo.repo.EmpoyeeRepo;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmpoyeeRepo empoyeeRepo;
	@Autowired 
	EmployeeLoginRepo employeeLoginRepo;
	
	@PostMapping(value="/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empoyeeDto){
		EmployeeDto employeeDto = employeeService.createEmployee(empoyeeDto);
		
		return new ResponseEntity<>(empoyeeDto,HttpStatus.CREATED);
		
	}
	@GetMapping(value="getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployees(),HttpStatus.OK);
		
	}
	@GetMapping(value="get/{eId}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable int eId){
		return new ResponseEntity<>(employeeService.getById(eId),HttpStatus.OK);
		
		
	}
	@PutMapping(value="update/{eId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int eId,@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<>(employeeService.updateEmployee(eId, employeeDto),HttpStatus.OK);
		
	}
	@DeleteMapping(value="delete/{eId}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable int eId ){
		return new ResponseEntity<>(employeeService.deletEmployeeDetails(eId),HttpStatus.NO_CONTENT);
		
	}
	@PostMapping(value="/create/image")
	public ResponseEntity<String> createEmployeeImage(@RequestParam ("file") MultipartFile file ,
			@RequestParam ("eName") String eName,@RequestParam ("eDept") String eDept,@RequestParam ("esalary") Double esalary,
			@RequestParam ("estatus") String estatus) throws IOException, SerialException, SQLException{
		return new ResponseEntity<>(employeeService.createEmployeeImage(file, eName, eDept, esalary, estatus),HttpStatus.CREATED);
		
	}
	//one to one mapping
	//One to many
	@PostMapping(value="/save")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeEntity empdata){
		empoyeeRepo.save(empdata);
		return new ResponseEntity<String>("DataSaved",HttpStatus.OK);
		
	}
	//paging
	@GetMapping(value="getAllEntity")
	Page<EmployeeEntity> getAllEntities(@RequestParam Optional<Integer> page){
		
		return empoyeeRepo.findAll(PageRequest.of(page.orElse(0), 1));
		
	}
	//searching -its just give the name if the toal name we gave otherwise no
	@GetMapping(value="getByEname")
	List<EmployeeEntity> getByEname(@RequestParam String eName) {
		return empoyeeRepo.findByeName(eName);
	}
	//it is used to give whole data if the name consist of single letter
	@GetMapping(value="/getWholeName")
	List<EmployeeEntity> getByEname(@RequestParam Optional<String> eName){
		return empoyeeRepo.findByeName(eName);
	}
	 /*@GetMapping(value="getAllEntity")
	Page<EmployeeEntity> getAllEntities(@RequestParam Optional<Integer> page,@RequestParam Optional<String> sortBy){
		 Pageable pageable=null;

		return empoyeeRepo.findAll(PageRequest.of(page.orElse(0), 3,Sort.Direction.ASC,sortBy.orElse("id")));
		
	}*/
	@PostMapping(value="saveDateTime")
	public ResponseEntity<Duration> saveEmployeeLoginDetails(@RequestBody EmployeeLogin employeeLogin){
		LocalTime logInTime = employeeLogin.logInTime(8, 30, 0);
		LocalTime logOutTime = employeeLogin.logOutTime(9, 0, 0);
		Duration totalWorkingHours = employeeLogin.totalWorkingHours(logInTime, logOutTime);
		employeeLoginRepo.save(employeeLogin);
		return new ResponseEntity<>(totalWorkingHours,HttpStatus.CREATED);
		
	}
	@PostMapping(value ="saveTimewithRequestParam")
	public ResponseEntity<Duration> saveEmployee(@RequestParam ("h1")int h1,@RequestParam ("h2")int h2, 
			                                     @RequestParam ("m1")int m1,@RequestParam("m2") int m2,
			                                     @RequestParam ("s1")int s1,@RequestParam ("s2")int s2
			                                    ){
		EmployeeLogin employeeLogin=new EmployeeLogin();
		LocalTime logInTime = employeeLogin.logInTime(h1, m1, s1);
		LocalTime logOutTime = employeeLogin.logInTime(h2, m2, s2);
		Duration totalWorkingHours = employeeLogin.totalWorkingHours(logInTime, logOutTime);
		employeeLoginRepo.save(employeeLogin);
		return new  ResponseEntity<>(totalWorkingHours,HttpStatus.CREATED);
		
	}
	//one to one
	@PostMapping(value="saveEmployeeWithLogin")
	public ResponseEntity<EmployeeEntity> saveEmployeeWithLogin(@RequestBody EmployeeEntity  employeeEntity){
		return new ResponseEntity<>(empoyeeRepo.save(employeeEntity),HttpStatus.CREATED);
		
	}
	 
	@PostMapping(value="saveEmployeeTimeCard")
	public ResponseEntity<EmployeeTimeCard> saveEmployeeTimeCardDetails(@RequestBody EmployeeTimeCard employeeTimeCard){
		return new ResponseEntity<>(employeeService.saveEmployeeTimeCard(employeeTimeCard),HttpStatus.CREATED);
	}

}
