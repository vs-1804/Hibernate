package com.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.sf.ehcache.hibernate.HibernateUtil;

public class HibernateUtils {
	
	private final static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
		try {
			/* Properties properties = new Properties();
	            properties.load(HibernateUtil.class.getResourceAsStream("/hibernate.properties"));*/

			// Load configuration from hibernate.cfg.xml
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		//	configuration.addAnnotatedClass(com.hibernate.entity.Employee.class);
			// Build SessionFactory
			return configuration.buildSessionFactory();
		} catch (Exception ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

}
