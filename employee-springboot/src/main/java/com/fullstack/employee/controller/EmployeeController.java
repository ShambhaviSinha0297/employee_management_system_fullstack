package com.fullstack.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.employee.entity.Employee;
import com.fullstack.employee.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vi")
public class EmployeeController {

	@Autowired
	private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    
    @GetMapping("/employees")
    public   List<Employee> getAllEmployees(){
    	return employeeService.getAllEmployee();  	
    }
    
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
    	if(employeeService.deleteEmployee(id)) {
    		return "Employee details deleted";
    	}
    	else {
    		return "No such employee";
    	}
    }
    
    @PutMapping("/employee/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
    	Employee emp = employeeService.updateEmployee(employee);
    	return emp;
    }
    
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
    	Employee emp = employeeService.getEmployeeById(id);
    	return emp;
    }

}
