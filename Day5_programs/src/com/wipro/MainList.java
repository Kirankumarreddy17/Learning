package com.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainList {
	
	
    private static List<EmployeeList> list= new ArrayList<>();
    private static Scanner sc  = new Scanner(System.in);
  //  Employeee e1= new Employeee();
    
 
 public static void main(String[] args) {
  while(true)
  {
   System.out.println("\n1.Add , 2.Delete , 3. Search , 4. View All");
   int choice = sc.nextInt();
   switch(choice)
   {
   case 1  -> addEmployee();
   case 2 -> deleteEmployee();
   case 4-> viewAll();
   
   }
  }
 }
 
 static void addEmployee() {
	 
     System.out.println("Enter id  , Name , salary");
     int id=sc.nextInt();
     String name= sc.next();
     double salary = sc.nextDouble();
     list.add(new EmployeeList(id,name,salary));
     }
     static void viewAll() {
    	 
         System.out.println("Employee Data\n");
         for(EmployeeList e: list) {
             System.out.println(e);
         }
     }
     static void deleteEmployee() {
    	 System.out.println("Enter the ID to delete: ");
    	 int id1 = sc.nextInt();
    	 boolean found = false;
    	 for(EmployeeList e: list) {
        	 if(id1 == e.getId()) {
        		 list.remove(e);
        		 System.out.println("Removed Successfully");
        		 found = true;
        		 break;
        	 }
         }
    	 if(!found) {
    		 System.out.println("Employee ID not found"); 
    	 }
    	 
     }
}
