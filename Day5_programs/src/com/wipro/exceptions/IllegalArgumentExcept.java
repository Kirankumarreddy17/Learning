package com.wipro.exceptions;
import java.util.Scanner;

// When you try to convert a string into a number (like int , double etc. ) but the string is not properly formatted as a number 
public class IllegalArgumentExcept {
	
	static void validate(int age)
	{
		
		if(age<0) 
		{
		throw new IllegalArgumentException("Age cannot be negative");}
		else {
			System.out.println("You have entered valid age :");
	}
	}
}




