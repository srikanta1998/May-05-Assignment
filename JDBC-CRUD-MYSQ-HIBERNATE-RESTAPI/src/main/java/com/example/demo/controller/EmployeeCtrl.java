package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeCtrl {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeByid(@PathVariable("id")int id)
	{
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping("/employee/")
	public String addEmployee(@RequestBody Employee employee)
	{
		employeeRepository.save(employee);
		return "Object is saved!";
	}
	
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee employee)
	{
		Employee employee1 = (Employee)employeeRepository.findById(employee.getId()).get();
		if(employee1.getId()==employee.getId())
		{
			employee1.setName(employee.getName());
			employee1.setSalary(employee.getSalary());
			employeeRepository.save(employee1);
		}
		return "Record Updated!";
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable("id")int id)
	{
		Employee employee1 = (Employee)employeeRepository.findById(id).get();
		if(employee1.getId()==id)
		{
			employeeRepository.delete(employee1);
		}
		return "Record Deleted!";
	}
}
