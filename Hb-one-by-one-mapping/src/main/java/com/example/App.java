package com.example;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Book;
import com.example.entity.Publisher;
import com.hibernate.util.HibernateUtils;

public class App 
{
    public static void main( String[] args ) { 
   
	/*	Publisher publisher = new Publisher("Jk Publications");
		Book book = new Book("Dargons Extinction");
		//book.setId(4);
		book.setPublisher(publisher);
		publisher.setBook(book);*/
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		Publisher publisher =session.get(Publisher.class, 202);
         System.out.println(publisher.getName()+"  "+ publisher.getBook().getTitle());
         
      // session.remove(publisher);
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
  
