package com.booking.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBService {
	private static SessionFactory factory;

	public static Session initDBSession() {
		try {
			factory = new Configuration()
            .configure("hibernate-config.xml") 
            // configures settings from hibernate.cfg.xml
            .buildSessionFactory();
			
			/*factory = new AnnotationConfiguration().configure().
			// addPackage("com.xyz") //add package if used.
					addAnnotatedClass(User.class).buildSessionFactory();*/
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory.openSession();
	}
}
