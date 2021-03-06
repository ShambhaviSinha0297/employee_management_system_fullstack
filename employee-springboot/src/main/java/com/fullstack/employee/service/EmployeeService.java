package com.fullstack.employee.service;

import java.util.List;

import com.fullstack.employee.entity.Employee;


public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
    boolean deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
}
