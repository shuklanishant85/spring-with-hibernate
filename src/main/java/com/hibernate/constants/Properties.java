package com.hibernate.constants;


public class Properties {
	
	public static final String DRIVER = AppProperties.getProperty("sqlite.driver.url");
	public static final String USERNAME = AppProperties.getProperty("sqlite.db.username");
	public static final String PASSWORD = AppProperties.getProperty("sqlite.db.password");
	public static final String DATABASE = AppProperties.getProperty("sqlite.db.name");;

}
