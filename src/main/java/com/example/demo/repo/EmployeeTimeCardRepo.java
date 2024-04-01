package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EmployeeTimeCard;

public interface EmployeeTimeCardRepo extends JpaRepository<EmployeeTimeCard, Integer> {

}
