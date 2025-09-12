package com.wipro.entity;




import com.wipro.entity.base.Address;
import com.wipro.entity.base.Person;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {

	private String subject;
	
	
	public Teacher()
	{}
	public Teacher(String name , Address addr , String subject)
	{
		
		super(name , addr);
		this.subject = subject;
	}
	public String getSubject() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}