package com.example.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.springmvc.dao.EmployeeRepository;
import com.example.springmvc.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository empRepo;
	
	public EmployeeServiceImpl(EmployeeRepository theEmpRepo) {
		empRepo = theEmpRepo;
	}

	@Override	
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override	
	public Employee findById(int theId) {
		Optional<Employee> result = empRepo.findById(theId);
		Employee emp = new Employee();
		if (result.isPresent()) {
			emp = result.get();
		}
		return emp;
	}

	@Override	
	public void save(Employee emp) {
		empRepo.save(emp);

	}

	@Override	
	public void deleteById(int id) {
		empRepo.deleteById(id);
	}

}
