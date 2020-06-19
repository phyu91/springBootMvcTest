package com.example.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvc.entity.Employee;
import com.example.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private List<Employee> empList = new ArrayList<Employee>();
	
	private EmployeeService empService;	
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

	/*
	 * @PostConstruct private void loadData() { Employee emp1 = new
	 * Employee(1,"Aye","Aye","aye@gmail.com"); Employee emp2 = new
	 * Employee(2,"Mya","Mya","mya@gmail.com"); Employee emp3 = new
	 * Employee(3,"Hla","Hla","hla@gmail.com");
	 * 
	 * empList.add(emp1); empList.add(emp2); empList.add(emp3);
	 * 
	 * }
	 */
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		empList=empService.findAll();
		theModel.addAttribute("employees", empList);
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee emp = new Employee();
		theModel.addAttribute("employee",emp);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		empService.save(emp);
		return "redirect:/employees/list";
		//return "list-employees";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		Employee emp = empService.findById(id);
		model.addAttribute("employee", emp);
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		empService.deleteById(id);
		return "redirect:/employees/list";
	}
		
	
}
