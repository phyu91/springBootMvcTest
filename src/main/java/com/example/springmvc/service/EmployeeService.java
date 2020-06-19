package com.example.springmvc.service;

import java.util.List;

import com.example.springmvc.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee emp);
	
	public void deleteById(int id);
}
