package com.wipro;
import com.wipro.Product;
public class ProductExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Through the ProductBuilder Class we are making Product class as Mutable
		Product p = new Product.ProductBuilder()
				.setName("Cricket Kit")
				.setPrice(3400.00)
				.build();
		p.show();		

	}	

}

