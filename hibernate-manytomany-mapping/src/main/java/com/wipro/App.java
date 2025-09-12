package com.wipro;

/**
 * Hello world!
 *
 */

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.model.Course;
import com.wipro.model.Student;
import com.wipro.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// to obtain/get the session from sessionfactory (It can be multiple session based on multiple services or work)
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// To create a  transaction ( Transient + Persistent) -- Transient when you do not to reflect and save in backend  but persistent to save into a backend
	   Transaction tx = session.beginTransaction();
	   Course c1 = new Course("Operating System"); //7,8
	   Course c2 = new Course("Microprocessor");
	   
	   Student kiran =  new Student("Kiran"); //4
	   Student shuhas =  new Student("Shuhas");
	   Student sreekanth =  new Student("sreekanth");
	   
	   kiran.addCourse(c1);
	   kiran.addCourse(c2);  
	   
	   shuhas.addCourse(c1);
	   
	    sreekanth.addCourse(c2);
	    
	   session.persist(kiran);
	   session.persist(shuhas);
	   session.persist(sreekanth);
	   tx.commit();
	   
	  // Session session1 = HibernateUtil.getSessionFactory().openSession();
	  Course course  = session.get(Course.class,1L);
	  System.out.println("Course details :" + course.getTitle());
	  course.getStudents().forEach(st->System.out.println("These Students are enrolled :" + st.getName()));
	   
	   }
}