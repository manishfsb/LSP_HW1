package org.howard.edu.lsp.assignment4.test;

import org.howard.edu.lsp.assignment4.implementation.CustomException;
import org.howard.edu.lsp.assignment4.implementation.IntegerSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerSet testObject = new IntegerSet();
		
		System.out.println(testObject.isEmpty());
		testObject.add(3);
		System.out.println(testObject.isEmpty());
		
		testObject.clear();
		System.out.println(testObject.toString());
		System.out.println(testObject.length());
		
		IntegerSet ints1 = new IntegerSet();
		
		System.out.println(ints1.toString());
		System.out.println(testObject.equals(ints1));
		
		int[] a = new int[] {-1, 5, 3, 5, 8, 6, 7};
		
		for (int i = 0; i < a.length; i ++) {
			testObject.add(a[i]);
		}
		
		int[] b = new int[] {1,2,3};
		for (int i = 0; i < b.length; i ++) {
			ints1.add(b[i]);
		}
		
		System.out.println(testObject.equals(ints1));
		
		
		// Checking if smallest and largest methods work
		try {
			System.out.println(testObject.smallest());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(testObject.largest());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Checking if modifying will affect the methods
		testObject.add(9);
		testObject.add(-111);
		try {
			System.out.println(testObject.largest());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(testObject.smallest());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//checking if the methods work for empty sets
		testObject.clear();
		
		try {
			System.out.println(testObject.largest());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(testObject.smallest());
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("1" + testObject.toString());
		System.out.println("2" + ints1.toString());
		
		
		testObject.union(ints1);

		System.out.println(testObject.toString());
		
		testObject.intersect(ints1);

		System.out.println(testObject.toString());
		
		ints1.add(9);
		

		System.out.println(testObject.toString());
		System.out.println(ints1.toString());
		testObject.diff(ints1);

		System.out.println(testObject.toString());
		
		
		//test1 
		
		
	}

}
