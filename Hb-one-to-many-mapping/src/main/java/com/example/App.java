package com.example;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Manufacturer;
import com.example.entity.Model;
import com.hibernate.util.HibernateUtils;

public class App 
{
    public static void main( String[] args ) { 
   
	Manufacturer manufacturer= new Manufacturer("BAJAJ");
	Model model = new Model();
	model.setManufacturer(manufacturer);
	model.setName("Platinum");
	Model model1 = new Model();
	model1.setManufacturer(manufacturer);
	model1.setName("Pulsar");
	 Set<Model> mlist= new HashSet<Model>();  
	 mlist.add(model);
	 mlist.add(model1);
	 manufacturer.setModel(mlist);
    	Session session = HibernateUtils.getSessionFactory().openSession();
    	Transaction tx=null;

    	try {
    		
    	tx=session.beginTransaction();
    	Manufacturer manu = session.get(Manufacturer.class, 3);
    	manu.setName("vikas");
    //	session.detach(manu);
   session.persist(manu);
    		tx.commit();
    		
    	} catch (Exception e) {
    		if (tx != null)
    			tx.rollback();
    		e.getStackTrace();
    	}
    	finally {
    		//session.close();
    	}
        }
    }
  
