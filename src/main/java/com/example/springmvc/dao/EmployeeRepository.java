package com.example.springmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmvc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllByOrderByLastNameAsc();
}
