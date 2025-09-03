package com.wipro;

public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating a string object using a literal
		
		String s = "Niti";  // String Pool in Heap 
		System.out.println(s.hashCode());
		// this gives the actual memory identity where it is stored
		System.out.println(System.identityHashCode(s));
		//  creating a string object using new keyword
		
		String s1 = new String("Nitin"); // Heap  
		
		System.out.println(s1.hashCode());  //if same content as S object has then it will give the same hash
		System.out.println(System.identityHashCode(s1)); // different memory and different value
		
		
		// Whenever the String class overrides
		// the hashCode() method then it is computing on the basis 
		// of the content not the memory location
		
		System.out.println(s==s1); // different memory references
		System.out.println(s.equals(s1)); // it check the content
		
	
		
	}

}
