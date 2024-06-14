package com.tka.OrganizationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee31;
import com.tka.OrganizationSystem.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {
	@Autowired
	MainService service;


	@PostMapping("addcountry") // API NAE
	public String addCountry(@RequestBody Country c) {
		//System.out.println(c);

	
		String msg= service.addCountry(c);
		return msg;
}
	
	// for upadte
	@PutMapping("updatecountry/{id}")  // API NAME
	public String updateCountry(@PathVariable int id,@RequestBody Country c ) {

		String msg= service.updateCountry(id,c);
		return msg;
}
	// for employee
	@PostMapping("addemp") // API Name
	public String addEmployee31(@RequestBody Employee31 emp) {
		String msg= service.addEmployee31(emp);
		return msg;
	}
	@PutMapping("updateemp")
	public String updateEmployee31(@RequestBody Employee31 emp)
	{
		String msg=service.updateEmployee31(emp); // create method in service clss
				return msg;
	}
	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
	
		String msg=service.deleteEmplyee31(id);
				return msg;
		
		
	}
	
	@GetMapping("getallemp")
	public List<Employee31> getAllEmployee()
	{
		List<Employee31> list= service.getAllEmployee31(); // create method in service class
		return list;
	}

@GetMapping("getempbyid/{id}")
public Employee31 ParticularById(@PathVariable int id)
{
	Employee31 emp=service.getParticularByID(id); // create method in service class
	return emp;
}
@GetMapping("getempbystatus/{status}")

public List<Employee31>getEmployee31ByStatus(@PathVariable String status) {
	List<Employee31>list =service.getEmployeeByStatus(status);

return list;
}
}