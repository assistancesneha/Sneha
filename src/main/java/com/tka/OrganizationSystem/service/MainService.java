package com.tka.OrganizationSystem.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee31;

@Service
public class MainService {

	// create method and pass arg and create dao layer
	@Autowired
	MainDao dao; // import
	public String addCountry(Country c) // void change in string
	{
	 String msg=dao.addCountry(c);
	
		if(Objects.isNull(msg)) // check msg
		{
			msg="country is not added";
			
		}
				return msg;
		
	}
	public String updateCountry(int id, Country c) {
		
		String msg= dao.updateCountry(id,c);
		if(Objects.isNull(msg)) {
			msg="Country is not Updatated..";
		}
		return msg;
		
	}
	
	


	public String addEmployee31(Employee31 emp) {
		String msg=dao.addEmployee3(emp); // click on create method in dao
		if(Objects.isNull(msg)) // check msg
		{
			msg="Employee Record is not added";
			
		}
				return msg;
		
	}
	public String updateEmployee31(Employee31 emp) {
		String msg=dao.updateEmployee3(emp); // click on create method in dao
		if(Objects.isNull(msg)) // check msg
		{
			msg="Employee Record is not updated";
			
		}
		return msg;
	}
	public String deleteEmplyee31(int id) {
		String msg=dao.deleteEmployee31(id); // click on create method in dao
		if(Objects.isNull(msg)) // check msg
		{
			msg="Employee Record is not deleteed";
			
		}
	
		return msg;
	}
	public List<Employee31> getAllEmployee31() {
		List<Employee31> list=dao.getAllEmployee31();
				
			if(Objects.isNull(list)) // check msg
				
			{
				list=null;
				
			}
				
		return list;
		
	}
	public Employee31 getParticularByID(int id) {
		Employee31 emp=dao.getPaticularById(id); // create method in dao
		if(Objects.isNull(emp))
		{
			emp=null;
		}
		return emp;
	}
	

	

public List<Employee31> getEmployee31ByStatus(String status) {
	List<Employee31> list=dao.getAllEmployeeByStatus(status);
	if(Objects.isNull(list)) // check msg
		
	{
		list=null;
		
	}
		
			return list;
}
}

	
