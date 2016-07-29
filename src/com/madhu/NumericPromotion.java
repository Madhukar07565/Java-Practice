package com.madhu;

public class NumericPromotion {
	public static void main(String... args){

			for(int i=0;i<10;i++)
			{
					for(int j=i;j<9;j++)
					{
							System.out.print("*");
					}
					System.out.println();
			}
			
			for(int i=0;i<10;i++)
			{
					for(int j=0;j<i;j++)
					{
							System.out.print("*");
					}
					System.out.println();
			}
	}
}