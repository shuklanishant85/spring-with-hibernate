package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateMain {
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("Niwesh");
		employee.setId(125608);
		employee.setRole("Associate L2");
		employee.setInsertTime(new Date());
		
		//get session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//save the model object
		session.save(employee);
		//commit transaction
		session.getTransaction().commit();
		//terminate session factory to end thread
		HibernateUtil.getSessionFactory().close();
	}
}
