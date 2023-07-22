package com.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;


@Controller
public class EmployeeController {
	@Autowired EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("employee",employeeService.getEmployeesList());
		return "index";
	}
	
	@GetMapping("/newEmp")
	public String addEmpForm()
	{
		return "new-emp";
	}
	
	@PostMapping("/saveemp")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/employee/update/{id}")
	public String updateemployee(@PathVariable(value="id")long id,Model model)
	{
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update-employee";
	}
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id")long id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
	

}
