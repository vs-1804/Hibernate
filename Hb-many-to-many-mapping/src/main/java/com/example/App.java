package com.example;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Course;
import com.example.entity.Student;
import com.hibernate.util.HibernateUtils;

public class App 
{
    public static void main( String[] args ) { 

		Session session = HibernateUtils.getSessionFactory().openSession();
	/*	Course course1=new Course("Java");
		Student stud1= new Student("Ajay");
		Student stud2= new Student("Neha");
		//Course course2=new Course("Python");
		Set<Student> list= new HashSet<>();
		list.add(stud1);
		list.add(stud2);
		course1.setStudent(list);*/
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Course course= session.get(Course.class, 2);
			Set<Student> student= course.getStudent();
			 for(Student stu : student ) {
				 System.out.println(stu.getName());
			 }
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.getStackTrace();
		} finally {
			 session.close();
		
	}}
}
