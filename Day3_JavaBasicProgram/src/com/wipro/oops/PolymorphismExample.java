package com.wipro.oops;



//E-commerce  -- users are paying using either credit card  ,  cod  ,  upi(Google Pay , PhonePe etc.)
//vendor specific implementation --  Abstract or Interface -- Abstraction
//Payment processing -- polymorphism
//user id  , password  , roles  -- Encapsulation(Data Validations)

//So payment class in which we have a paymentProcessing method which is common for all the vendors

//Base/Parent/Super Class which Amazon has created 
class PaymentMethod
{
	 // Example of Overloading
	public void processPayment(double amount)
	{
		System.out.println("Processing payment is done of Rs. " + amount);
	}
	
	public void processPayment(int amount , int gstNumber)
	{
		System.out.println("Processing payment is done of Rs. " + amount);
	}
}

// Child/Sub/Derived Class overriding the processPayment Method
class Zara extends PaymentMethod
{
	
	class CreditCard extends PaymentMethod
	{
		
//		public void processPayment(double amount)
//		{
//			System.out.println("Payment is done via Credit Card :" + amount);
//		}
		
	}
	
	class Upi extends PaymentMethod
	{
		
		public void processPayment(double amount)
		{
			System.out.println("Payment is done via Upi :"+ amount);
		}
		
	}



}


//Child/Sub/Derived Class
class Nike extends PaymentMethod
{
	
	class CreditCard extends PaymentMethod
	{
		
		public void processPayment(double amount , int gstNumber)
		{
			System.out.println("Payment is done via Credit Card :" + amount);
		}
		
		public void processPayment(double amount )
		{
			System.out.println("Payment is done via Credit Card without GST :" + amount);
		}
		
		
	}
	
	class Upi extends PaymentMethod
	{
		
		public void processPayment(double amount , int gstNumber)
		{
			System.out.println("Payment is done via Upi  :" + amount);
		}
		
	}



}
