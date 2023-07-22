package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployeesList();
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeById(long id);
	
	public void deleteEmployee(long id);


}
