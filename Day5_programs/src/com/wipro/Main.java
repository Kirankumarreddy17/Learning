package com.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
 
 private static List<Employee> list= new ArrayList<>();
 private static Scanner sc  = new Scanner(System.in);
 
 
 public static void main(String[] args) {
  while(true)
  {
   System.out.println("\n1.Add , 2.Delete , 3. Search , 4. View All, 5.adding at particular position, 6.exit");
   int choice = sc.nextInt();
   switch(choice)
   {
   case 1  -> addEmployee();
   case 2 -> deleteEmployee();
   case 3 -> searchEmployee();
   case 4-> viewAll();
   case 5 -> addEmployeeAtposition();
   case 6 -> exit();
   
   }
  }
 }
 
 
 
	 static void addEmployee() {
	  
	  System.out.println("Enter id  , Name , salary");
	  int id=sc.nextInt();
	  String name= sc.next();
	  double salary = sc.nextDouble();
	  list.add(new Employee(id,name,salary));
	  
	  
	 }
	 static void deleteEmployee() {
		 System.out.println("Enter the employee ID to delete: ");
		 int id = sc.nextInt();
		 boolean removed = false;
		 for (int i =0; i<list.size();i++) {
			 if (list.get(i).getId() == id) {
				 list.remove(i);
				 System.out.println("Employee removed.");
				 removed = true;
				 break;
			 }
		 }
		 if (!removed) {
			 System.out.println("Employee with ID " + id+" not found");
	   }
		 
		 
	}
	 
	 
	 
	 
	 static void viewAll() {
	  System.out.println("Employee Data\n");
	  for(Employee e: list) {
	   System.out.println(e);
	  }
	 }
	 
	 
	 
	 
	 static void searchEmployee() {
	  System.out.println("Enter the mloyee Id to search: ");
	   int id = sc.nextInt();
	   boolean found = false;
	   for (Employee emp : list) {
		   if (emp.getId() == id) {
			   System.out.println("Id: "+emp.getId() + "name: "+emp.getName() + "Salaray: "+emp.getSalary());
			   found = true;
			   break;
		   }
		   
	   }
	   if (!found) {
		   System.out.println("Employee with Id "+id+"not found");
	   }
	   
	}
	 
	 
	 static void addEmployeeAtposition(){
		 System.out.println("Enter the position where to add the employee: ");
		 int position = sc.nextInt();
		 System.out.println("Enter id, Name, salary");
		 int id = sc.nextInt();
		 String name = sc.next();
		 double salary = sc.nextDouble();
		 if(position >= 0 && position <= list.size())
			 list.add(position, new Employee(id,name,salary));
		 else
			 System.out.println("invalid Index");
	 }
 
	 static void exit() {
		 System.exit(0);
	 
	 }
}