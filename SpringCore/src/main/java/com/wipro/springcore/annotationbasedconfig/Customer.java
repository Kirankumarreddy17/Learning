package com.wipro.springcore.annotationbasedconfig;


import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	public void welcomeCustomer()
	{
		
		System.out.println("Annotation Based Config File");
	}

}