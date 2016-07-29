package com.madhu;

public class UserDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;
	UserDefinedException(String str){
		super(str);
	}
	
	
public static void main(String[] args) {
	
	try {
		int a = 1;
		if(a==0)
		{
		//throw new UserDefinedException("User Defined Exception");
		}
		else
		{
			System.out.println("Nothinggg...");
			throw new ArithmeticException("Exception......");
			
		}
	} /*catch (UserDefinedException e) {
		e.printStackTrace();
	}*/ finally {
	    System.out.println("in finally");
	}
}
}
