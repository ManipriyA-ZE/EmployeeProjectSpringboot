package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeEntity;
@Repository
public interface EmpoyeeRepo extends JpaRepository<EmployeeEntity, Integer> {



	List<EmployeeEntity> findByeName(String eName);
	
	
	@Query("select e from EmployeeEntity e where eName like %?1%")
	List<EmployeeEntity> findByeName(Optional<String> eName);

	

	



}
