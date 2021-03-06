package com.fullstack.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.employee.entity.Employee;
import com.fullstack.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		return true;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee empFound = employeeRepo.findById(id).get();
		return empFound;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = employeeRepo.findById(employee.getId()).orElse(null);
		existingEmployee.setId(employee.getId());
		existingEmployee.setName(employee.getName());
		existingEmployee.setLocation(employee.getLocation());
		existingEmployee.setDepartment(employee.getDepartment());
		return employeeRepo.save(existingEmployee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployees = employeeRepo.findAll();
		return allEmployees;
	}
	

}
