package com.madhu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapCheck {

	public void generateRandomNumbers()
	{
		Random r = new Random();
		for(int i=0;i<10;i++)
		{
			int a = r.nextInt(10001);
			System.out.println("Random Numbers are...."+a);
		}
	}
	
	public int getValue()
	{
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 4);
		System.out.println("before size is "+map.size());
		System.out.println("<<<<<<<"+map.remove("a"));
		System.out.println("++++++"+map.size());
		System.out.println("!!!!!!!! The method call returns the previous value associated with key, or null if there was no mapping for key."+map.put("a", 6));
		return map.put("a", 3);
	}
	public static void main(String[] args) {

		MapCheck m = new MapCheck();
		System.out.println( ">>>>>>> "+m.getValue());
		m.generateRandomNumbers();
	}

}
