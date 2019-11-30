package com.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Employee1;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static SessionFactory sessionAnnotationFactory;
	private static SessionFactory sessionJavaConfigFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			// create sessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			System.out.println("hibernate configurations loaded");
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build();
			System.out.println("hibernate service registry created");
			SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
			System.out.println("session factory created");
			return sessionFactory;
		} catch (Throwable exception) {
			System.err.println("Initial SessionFactory creation failed : " + exception);
			throw new ExceptionInInitializerError(exception);
		}
	}

	private static SessionFactory buildSessionAnnotationFactory() {
		try {
			// create sessionFactory from hibernate-annotation.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure("hibernate-annotation.cfg.xml");
			System.out.println("hibernate configuration loaded");
			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build();
			System.out.println("hibernate service registry created");
			SessionFactory sessionAnnotationFactory = configuration.buildSessionFactory(registry);
			System.out.println("session factory created");
			return sessionAnnotationFactory;
		} catch (Throwable exception) {
			System.err.println("Initial session factory creation failed" + exception);
			throw new ExceptionInInitializerError(exception);
		}
	}

	private static SessionFactory buildSessionJavaConfigFactory() {
		try {
			// create sessionFactory from java configuration
			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			properties.put("hibernate.connection.driver_class", "org.sqlite.JDBC");
			properties.put("hibernate.connection.url", "jdbc:sqlite:C:/sqlite/user.db");
			properties.put("hibernate.current_session_context_class", "thread");
			properties.put("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(Employee1.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			SessionFactory sessionJavaConfigFactory = configuration.buildSessionFactory(serviceRegistry);
			System.out.println("session factory created");
			return sessionJavaConfigFactory;
		} catch (Throwable exception) {
			System.err.println("Initial session factory creation failed" + exception);
			throw new ExceptionInInitializerError(exception);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionAnnotationFactory() {
		if (null == sessionAnnotationFactory) {
			sessionAnnotationFactory = buildSessionAnnotationFactory();
		}
		return sessionAnnotationFactory;
	}

	public static SessionFactory getsessionJavaConfigFactory() {
		if (null == sessionJavaConfigFactory) {
			sessionJavaConfigFactory = buildSessionJavaConfigFactory();
		}
		return sessionJavaConfigFactory;
	}
}
