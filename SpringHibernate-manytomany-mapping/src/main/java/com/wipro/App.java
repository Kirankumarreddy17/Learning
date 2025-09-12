package com.wipro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.config.AppConfig;
import com.wipro.entity.Courses;
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
        Student student = new Student("anusha");
        student.addCourse(new Courses("java"));
        student.addCourse(new Courses("servlet"));
        
       
      
         service.saveData(student);
         Student fetchedStudent = service.getStudent(1L);
      // fetchedStudent.getCourses().forEach(c->System.out.println(c.getTitle()));
         System.out.println(fetchedStudent);
    
         
       
    }
}
