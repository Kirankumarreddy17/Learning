package com.wipro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.config.AppConfig;
import com.wipro.entity.Course;
import com.wipro.entity.ReportCard;
import com.wipro.entity.Student;
import com.wipro.service.StudentService;

/**
 * Hello world!
 *
 */



public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
	    
        StudentService service =  ctx.getBean(StudentService.class);
        Student student = new Student("bharath");
        student.addCourse(new Course("python"));
        student.addCourse(new Course("ReactJS"));
        
        ReportCard rc = new ReportCard(540);
      
         student.setReportcard(rc);
         service.saveData(student);
       
         
       
    }
}
