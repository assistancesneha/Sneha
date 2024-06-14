package com.tka.OrganizationSystem.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee31;

@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;
	private Object status;
	// for add record
	// create method here
	public String addCountry(Country c)  // MainDao call in service method so go to  MainService page write code ther
	{
	Session session=null; // for sesssion
	Transaction tx=null; // for transaction
	String msg=null;   // for message display
	try
	{
	session=factory.openSession();
	tx=session.beginTransaction();
	session.persist(c);
	tx.commit();
	msg="Country is added";
	}
	catch (Exception e) {
		// TODO: handle exception
	
	{
		// check rolback;
		if (tx!=null)
			tx.rollback();
	}
	e.printStackTrace();
}finally
	{
	if (session!=null)
	{
		session.close();
	}
	}
	return msg;
	}
	
	// for update
	public String updateCountry(int id, Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {			
			session= factory.openSession();
			tx=session.beginTransaction();

			Country country= session.get(Country.class, id);

			country.setCname(c.getCname()); // for update data
			session.merge(country);//  for save daTA
			tx.commit();

			msg="Country is updatated...";	// MESSSAGE DIAPLSY

		}catch (Exception e) {
			// TODO: handle exception

			if(tx!=null) {
				tx.rollback();
			}

			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

		return msg;

	}
	
	// FOR DELETE


public String deleteRecord(int id) {
	
	Session session=null; // for sesssion
	Transaction tx=null; // for transaction
	String msg=null;   // for message display
	Country country= session.get(Country.class, id);

	try
	{
	session=factory.openSession();
	tx=session.beginTransaction();
	session.remove(id);
	tx.commit();
	msg="Country is deleted";
	}
	catch (Exception e) {
		// TODO: handle exception
	
	{
		// check rolback;
		if (tx!=null)
			tx.rollback();
	}
	e.printStackTrace();
}finally
	{
	if (session!=null)
	{
		session.close();
	}
	}
	return msg;
	}

// for employee
public String addEmployee3(Employee31 emp) {
	
	Session session=null; // for sesssion
	Transaction tx=null; // for transaction
	String msg=null;   // for message display
	try
	{
	session=factory.openSession();
	tx=session.beginTransaction();
	session.persist(emp);
	tx.commit();
	msg="Employee is added";
	}
	catch (Exception e) {
		// TODO: handle exception
	
		// check rolback;
		if (tx!=null)
		{
			tx.rollback();
	}
	
	e.printStackTrace();
}
	finally {
	
	if (session!=null)
	{
		session.close();
	}
	
	
	}
	return msg;

}

public String updateEmployee3(Employee31 emp) {
	Session session=null; // for sesssion
	Transaction tx=null; // for transaction
	String msg=null;   // for message display
	try
	{
	session=factory.openSession();
	tx=session.beginTransaction();
	Employee31 employee=session.get(Employee31.class,emp.getId());
	
	employee.setName(emp.getName());
	employee.setCountry(emp.getCountry());
	employee.setCreatedby(emp.getCreatedby());
	employee.setCreateddtm(emp.getCreateddtm());
	employee.setUpdatedby(emp.getUpdatedby());
	employee.setUpdateddtm(emp.getUpdateddtm());
	employee.setDepartment(emp.getDepartment());
	employee.setStatus(emp.getStatus());
	employee.setPhoneno(emp.getPhoneno());
	employee.setEmailid(emp.getEmailid());
	employee.setSalary(emp.getSalary());
	
	session.merge(employee);
	tx.commit();
	msg="Employee is updated";
	}
	catch (Exception e) {
		// TODO: handle exception
	
		// check rolback;
		if (tx!=null)
		{
			tx.rollback();
	}
	
	e.printStackTrace();
}
	finally {
	
	if (session!=null)
	{
		session.close();
	}
	
	
	}
	return msg;


	
}

public String deleteEmployee31(int id) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;

	try {

		session=factory.openSession();
		tx=session.beginTransaction();

		Employee31 emp= session.get(Employee31.class, id);
		session.remove(emp);
		tx.commit();
		msg="Employee is Deleted...";

	}catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();

	}finally {

		if(session!=null) {
			session.close();
		}

	}
	return msg;
}


public List<Employee31> getAllEmployee31() {
	Session session=null; // for sesssion
	Transaction tx=null; // for transaction
	List<Employee31>list=null;   // for message display
	String hqlQuery="from Employee31";
	try
	{
	session=factory.openSession();
	tx=session.beginTransaction();
	
	Query<Employee31>query=session.createQuery(hqlQuery,Employee31.class);
	list=query.list();
	tx.commit();
	}
	catch (Exception e) {
		// TODO: handle exception
	
		// check rolback;
		if (tx!=null)
		{
			tx.rollback();
	}
	
	e.printStackTrace();
}
	finally {
	
	if (session!=null)
	{
		session.close();
	}
	
	
	}
	return list;
}

public Employee31 getPaticularById(int id) {
	Session session=null; // for sesssion
	Transaction tx=null; // for transaction
	Employee31 emp=null;   // for message display
	try
	{
	session=factory.openSession();
	tx=session.beginTransaction();
emp=session.get(Employee31.class, id);
	tx.commit();
	
	}
	catch (Exception e) {
		// TODO: handle exception
	
		// check rolback;
		if (tx!=null)
		{
			tx.rollback();
	}
	
	e.printStackTrace();
}
	finally {
	
	if (session!=null)
	{
		session.close();
	}
	
	
	}
	return emp;


}


	

public List<Employee31> getEmployee31ByStatus() {
	Session session=null; // for sesssion
	Transaction tx=null; // for transaction
	List<Employee31>list=null;   // for message display
	String hqlQuery="from Employee31 where status:=mystatus";
	try
	{
	session=factory.openSession();
	tx=session.beginTransaction();
	
	Query<Employee31>query=session.createQuery(hqlQuery,Employee31.class);
	query.setParameter("mystatus",status);
	list=query.list();
	tx.commit();
	}
	catch (Exception e) {
		// TODO: handle exception
	
		// check rolback;
		if (tx!=null)
		{
			tx.rollback();
	}
	
	e.printStackTrace();
}
	finally {
	
	if (session!=null)
	{
		session.close();
	}
	
	
	}
	return list;
}
}











	



