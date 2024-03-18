package com.hibernate.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Address;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Gender;
import com.hibernate.util.HibernateUtils;


public class App 
{
    public static void main( String[] args )
    {
    	
   
		Session session = HibernateUtils.getSessionFactory().openSession();
	 

	  
	   
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		Employee e= session.get(Employee.class,1);
		
		System.out.println(e.getPermanentAddress().getCity());
			tx.commit();
		} catch (HibernateException e) {
			System.err.println("Error");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
    }
      
    }
}
