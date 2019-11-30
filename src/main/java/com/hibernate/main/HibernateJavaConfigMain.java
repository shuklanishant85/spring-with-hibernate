package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.model.Employee1;
import com.hibernate.util.HibernateUtil;

public class HibernateJavaConfigMain {
	public static void main(String[] args) {
		Employee1 employee = new Employee1();
		employee.setName("Sajal");
		employee.setId(123456);
		employee.setRole("assistant manager");
		employee.setInsertTime(new Date());
		
		//get session
		Session session = HibernateUtil.getsessionJavaConfigFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//save the model object
		session.save(employee);
		//commit transaction
		session.getTransaction().commit();
		//terminate session factory to end thread
		HibernateUtil.getsessionJavaConfigFactory().close();
	}
}
