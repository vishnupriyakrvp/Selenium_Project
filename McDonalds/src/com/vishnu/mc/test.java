package com.vishnu.mc;

import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap m= new HashMap();
		Object o1= new Object();
		Object o2=o1;
		m.put(o1, 1);
		
		m.put(o2, 2);
		System.out.println(""+m.get(o1));
	}

}
