package com.productapp.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException  extends RuntimeException{
	
	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
