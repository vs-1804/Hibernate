package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Contractual_Employee;
import com.example.entity.Employee1;
import com.example.entity.Regular_Employee;
import com.hibernate.util.HibernateUtils;

public class App 
{
    public static void main( String[] args ) {
	Session session = HibernateUtils.getSessionFactory().openSession();
	Transaction tx=null;
	Employee1 emp = new Employee1("Rajesh");
	Contractual_Employee ce= new Contractual_Employee("Vikas Singh ", 200,"150 Days");
	Regular_Employee re= new Regular_Employee();
	re.setId(4);
	re.setBonus(100);
	re.setSalary(10000);
	try {
		tx=session.beginTransaction();
		session.merge(re);
		tx.commit();
		
	} catch (Exception e) {
		if (tx != null)
			tx.rollback();
		e.getStackTrace();
	}
	finally {
		session.close();
	}
    }
}
