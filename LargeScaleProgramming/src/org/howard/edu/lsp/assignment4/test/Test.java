package org.howard.edu.lsp.assignment4.test;

import java.util.Arrays;

import org.howard.edu.lsp.assignment4.implementation.CustomException;
import org.howard.edu.lsp.assignment4.implementation.IntegerSet;


/**
 * 
 * @author manishbasnet
 * driver class tests if the methods work correctly
 * we test all the methods throughout
 * add, remove, clear, length, toString, isEmpty methods are tested throughout and in between tests of other methods
 * union, intersection and difference methods are tested for correctness and if they work with changes to the object structure
 */
public class Test {

	public static void main(String[] args) {
		
		//Initializing two testObjects to use methods of IntegerSet class
		IntegerSet testObject = new IntegerSet();
		IntegerSet test1 = new IntegerSet();
		
		
		//checking isEmpty
		System.out.println( "Set1 = " + testObject.toString());
		System.out.println("Checking if empty: " + testObject.isEmpty() + "\n");
		
		//checking add
		testObject.add(3);
		System.out.println("After adding an element \n" + "Set1 = " + testObject.toString() + "\n" + "Checking if empty: " + testObject.isEmpty() );
		
		System.out.println("Checking length: " + testObject.length() + "\n");
		
		//checking clear
		testObject.clear();
		System.out.println("After clearing, Set1 = " + testObject.toString());
		System.out.println("Checking length after clearing the set: " + testObject.length() + "\n");

		
		System.out.println("Set2 : " + test1.toString());
		System.out.println("Checking if empty: " + test1.isEmpty());
		System.out.println("Checking the length of set2: " + test1.length());
		
		//checking equals method
		System.out.println("Checking if the Set1 equals Set2 : " + testObject.equals(test1) + "\n");

		
		//Initializing two int arrays to add to the set and test some methods 
		int[] a = new int[] {-1, 6, 5, 3, 5, 8, 8, 6, 7};
		int[] b = new int[] {1, 2, 3, 3, 2, 1, 0, 1231231};
		
		System.out.println("Array1 = " + Arrays.toString(a));
		System.out.println("Array2 = " + Arrays.toString(b));
		
		
		for (int i = 0; i < a.length; i ++) {
			testObject.add(a[i]);
		}
		
		//checks if duplicates will be added with the add method
		System.out.println("After adding elements of array1 to our set, Set1 = " + testObject.toString());
		
		
		for (int i = 0; i < b.length; i ++) {
			test1.add(b[i]);
		}
		
		System.out.println("After adding elements of array2 to our set, Set2 = " + test1.toString());
		
		//checking equals method
		System.out.println("Checking if set1 = set2 now:  " + testObject.equals(test1) + "\n");
		
		
		// Checking if smallest and largest method works for set1
		try {
			System.out.println("Smallest element of Set1 = " + testObject.smallest());
		} 
		catch (CustomException e) {
			e.printStackTrace();	
		}
		
		try {
			System.out.println("Biggest element of Set1 = " + testObject.largest() + "\n");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		// Checking if smallest and largest method works for set2
		try {
			System.out.println("Smallest element of Set2 = " + test1.smallest());
		} 
		catch (CustomException e) {
			e.printStackTrace();	
		}
		
		try {
			System.out.println("Biggest element of Set2 = " + test1.largest() + "\n");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		
		//Checking if modifying the sets will affect the methods
		testObject.add(9);
		test1.add(-1);
		
		//testing the remove method
		testObject.remove(-1);
		test1.remove(1231231);
		
		
		System.out.println("After adding and removing some elements of both sets: \n" + "Set1: " + testObject.toString() + "\n" + "Set2: " + test1.toString() + "\n");
		
		try {
			System.out.println("Set1 largest now = " + testObject.largest());
		} catch (CustomException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Set1 smallest now = " + testObject.smallest() + "\n");
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Set2 largest now = " + test1.largest());
		} catch (CustomException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Set2 smallest now = " + test1.smallest() + "\n");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//checking if the methods work for empty sets
		testObject.clear();
		
		System.out.println("After clearing set1: " + "\n" + "Set1: " + testObject.toString() + "\n" + "Set2: "  + test1.toString() + "\n");
		
		//checking for exceptions
		try {
			System.out.println(testObject.largest());
		} catch (CustomException e) {
			System.out.println("Largest element of set1 = " + e.getMessage());
		}
		try {
			System.out.println(testObject.smallest());
		} catch (CustomException e) {
			System.out.println("Smallest element of set1 = " + e.getMessage() + "\n");
		}
		
		
		System.out.println("Union:");

		//testing the union method where set1 empty and set2 not empty
		testObject.union(test1);
		System.out.println("After set1 union set2, set1 = " + testObject.toString() + "\n");
		
		
		testObject.clear();
		test1.clear();
		
		
		//testcase1 where length of set1 < length of set2
		int[] c = new int[] {-4,5, 5};
		
		int[] d = new int[] {1,2,3, 2, 3};
		
		for (int i = 0; i < c.length; i ++) {
			testObject.add(c[i]);
		}
		
		for (int i = 0; i < d.length; i++) {
			test1.add(d[i]);
		}
		
		//testing the length function wherever possible
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.union(test1);
		System.out.println("After set1 union set2, set1 = " + testObject.toString() + "\n");
		
		
		//testcase2 where length of set1 > length of set2
		test1.clear();
		testObject.clear();
		
		int[] e = new int[] {-1,-2, 2, 3, 4,5};
		
		int[] f = new int[] {1, 2, 3, 2, 1};
		
		for (int i = 0; i < e.length; i ++) {
			testObject.add(e[i]);
		}
		
		for (int i = 0; i < f.length; i++) {
			test1.add(f[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.union(test1);
		System.out.println("After set1 union set2, set1 = " + testObject.toString() + "\n");
		
		//testcase3 where set2 is empty
		test1.clear();
		testObject.clear();
		
		int[] g  = new int[] {1, 2, 3, 2, 1};
		int[] h = new int[] {};
		
		for (int i = 0; i < g.length; i ++) {
			testObject.add(g[i]);
		}
		
		for (int i = 0; i < h.length; i++) {
			test1.add(h[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.union(test1);
		System.out.println("After set1 union set2, set1 = " + testObject.toString() + "\n");
		
		

		System.out.println("Intersect:");
		//testing the intersect method
		
		//testcase1 where there are no common elements
		testObject.clear();
		test1.clear();
//		using the same arrays initialized before
//		int[] c = new int[] {-4,5, 5};
//		
//		int[] d = new int[] {1,2,3, 2, 3};
//		
		for (int i = 0; i < c.length; i ++) {
			testObject.add(c[i]);
		}
		
		for (int i = 0; i < d.length; i++) {
			test1.add(d[i]);
		}
		
		//testing the length function wherever possible
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.intersect(test1);
		System.out.println("After set1 intersects set2, set1 = " + testObject.toString() + "\n");
		
		
		//testcase2 where length of set1 > length of set2
		test1.clear();
		testObject.clear();
		
//		int[] e = new int[] {-1,-2, 2, 3, 4,5};
//		
//		int[] f = new int[] {1, 2, 3, 2, 1};
//		
		for (int i = 0; i < e.length; i ++) {
			testObject.add(e[i]);
		}
		
		for (int i = 0; i < f.length; i++) {
			test1.add(f[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.intersect(test1);
		System.out.println("After set1 intersects set2, set1 = " + testObject.toString() + "\n");
		
		//testcase3 where set2 is empty
		test1.clear();
		testObject.clear();
//		
//		int[] g  = new int[] {1, 2, 3, 2, 1};
//		int[] h = new int[] {};
//		
		for (int i = 0; i < g.length; i ++) {
			testObject.add(g[i]);
		}
		
		for (int i = 0; i < h.length; i++) {
			test1.add(h[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.intersect(test1);
		System.out.println("After set1 intersect set2, set1 = " + testObject.toString() + "\n");
		
		//testcase3 where set2 is empty
		test1.clear();
		testObject.clear();
//				
//				int[] g  = new int[] {1, 2, 3, 2, 1};
//				int[] h = new int[] {};
//				
		for (int i = 0; i < h.length; i ++) {
			testObject.add(h[i]);
		}
		
		for (int i = 0; i < g.length; i++) {
			test1.add(g[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.intersect(test1);
		System.out.println("After set1 intersect set2, set1 = " + testObject.toString() + "\n");
			
		
		//testing the diff method
		//testcase1 where the the difference should be the first set
		
		System.out.println("Difference: ");
		testObject.clear();
		test1.clear();
//		using the same arrays initialized before
//		int[] c = new int[] {-4,5, 5};
//		
//		int[] d = new int[] {1,2,3, 2, 3};
//		
		for (int i = 0; i < c.length; i ++) {
			testObject.add(c[i]);
		}
		
		for (int i = 0; i < d.length; i++) {
			test1.add(d[i]);
		}
		
		//testing the length function wherever possible
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.diff(test1);
		System.out.println("After set1 difference set2, set1 = " + testObject.toString() + "\n");
		
		
		//testcase2 where length of set1 > length of set2
		test1.clear();
		testObject.clear();
		
//		int[] e = new int[] {-1,-2, 2, 3, 4,5};
//		
//		int[] f = new int[] {1, 2, 3, 2, 1};
//		
		for (int i = 0; i < e.length; i ++) {
			testObject.add(e[i]);
		}
		
		for (int i = 0; i < f.length; i++) {
			test1.add(f[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.diff(test1);
		System.out.println("After set1 difference set2, set1 = " + testObject.toString() + "\n");
		
		//testcase3 where set2 is empty
		test1.clear();
		testObject.clear();
//		
//		int[] g  = new int[] {1, 2, 3, 2, 1};
//		int[] h = new int[] {};
//		
		for (int i = 0; i < g.length; i ++) {
			testObject.add(g[i]);
		}
		
		for (int i = 0; i < h.length; i++) {
			test1.add(h[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.diff(test1);
		System.out.println("After set1 difference set2, set1 = " + testObject.toString() + "\n");
		
		//testcase3 where set2 is empty
		test1.clear();
		testObject.clear();
//				
//				int[] g  = new int[] {1, 2, 3, 2, 1};
//				int[] h = new int[] {};
//				
		for (int i = 0; i < h.length; i ++) {
			testObject.add(h[i]);
		}
		
		for (int i = 0; i < g.length; i++) {
			test1.add(g[i]);
		}
		
		System.out.println("Set1: " + testObject.toString() + " Length of set1 = " + testObject.length() + "\n" + "Set2: " + test1.toString() + " Length of set2 = " + test1.length() );
		testObject.diff(test1);
		System.out.println("After set1 difference set2, set1 = " + testObject.toString() + "\n");
		
		
		System.out.println("All test cases passed !");
		
	}

}
