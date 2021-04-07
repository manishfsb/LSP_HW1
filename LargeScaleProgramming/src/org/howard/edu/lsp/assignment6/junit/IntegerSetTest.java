package org.howard.edu.lsp.assignment6.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.howard.edu.lsp.assignment6.integerset.CustomException;
import org.howard.edu.lsp.assignment6.integerset.IntegerSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerSetTest {

	IntegerSet firstTestObject, secondTestObject;
	ArrayList<Integer> testSet;
	
	ArrayList<Integer> testUnionSet;
	
	@BeforeEach
	@DisplayName("Initializing two IntegerSet objects that have been filled with some values")
	public void setUp() {
		
		firstTestObject = new IntegerSet();
		
		
		int[] addTofirstTestObject = {213, -12, 7, 7890};
						
		for (int j = 0; j < addTofirstTestObject.length; j ++) {
			firstTestObject.add(addTofirstTestObject[j]);
		}
		
		secondTestObject = new IntegerSet();
		
		int[] addToSecondTestObject = {1, 25, 751, 12, 76, -1234};
		for (int i = 0; i < addToSecondTestObject.length; i ++) {
			secondTestObject.add(addToSecondTestObject[i]);
		}
		
		testSet = new ArrayList<>();
		testUnionSet = new ArrayList<>();
		
		//firstTestObject = {213, -12, 7, 7890}
		//secondTestObject = {1, 25, 751, 12, 76, -1234}
		
	}
//		
	@Test
	@DisplayName("Testing the add method")
	public void testAdd() {
		
		firstTestObject.add(0);
		firstTestObject.add(120);
		
		//testing if duplicates get added
		firstTestObject.add(213);
		firstTestObject.add(-12);
		
		
		int[] addToTestSet = {213, -12, 7, 7890, 0, 120};
		
		for (int i = 0; i < addToTestSet.length; i++) {
			testSet.add(addToTestSet[i]);
		}
		
		assertEquals(firstTestObject.getSet(), testSet);
		testSet.clear();		
	}
		

//	{213, -12, 7, 7890}
	
	@Test
	@DisplayName("Testing the remove method")
	void testRemove() {

		firstTestObject.remove(213);
		firstTestObject.remove(-12);
		firstTestObject.remove(500);
		
		int[] arr1 = {7, 7890};
		
		for (int i = 0; i < arr1.length; i++) {
			testSet.add(arr1[i]);
		}
		
		assertEquals(firstTestObject.getSet(), testSet);
		testSet.clear();

	}
	
	@Test
	@DisplayName("Testing the clear method")
	void testClear() {
		firstTestObject.clear();
		assertEquals(firstTestObject.getSet(), testSet);
		
		firstTestObject.add(1);
		firstTestObject.add(2);
		firstTestObject.clear();
		
		assertEquals(firstTestObject.getSet(), testSet);
	}
	
	
	@Test
	@DisplayName("Testing the length method")
	void testLength() {
		assertEquals(firstTestObject.length(), 4);
		assertEquals(secondTestObject.length(), 6);
		
		firstTestObject.clear();
		assertEquals(firstTestObject.length(), 0);		
	}
	
	@Test
	@DisplayName("Testing the equals method")
	void testEquals() {
		
		assertEquals(firstTestObject.equals(secondTestObject), false);
		
		//copying elements of secondTestObject to firstTestObject
		firstTestObject.clear();
		int[] arr2 = {1, 25, 751, 12, 76, -1234};
		
		for (int i = 0; i < arr2.length; i++) {
			firstTestObject.add(arr2[i]);
		}
		
		assertTrue(secondTestObject.equals(firstTestObject));
		
		secondTestObject.add(0);
		assertEquals(secondTestObject.equals(firstTestObject), false);
		

		assertTrue(secondTestObject.equals(secondTestObject));
	}
	

	//firstTestObject = {213, -12, 7, 7890}
	//secondTestObject = {1, 25, 751, 12, 76, -1234}

	@Test
	@DisplayName("Testing the contains method")
	void testContains() {
		assertTrue(firstTestObject.contains(213));
		assertEquals(firstTestObject.contains(2134), false);
		assertTrue(secondTestObject.contains(-1234));
		assertEquals(secondTestObject.contains(-123), false);
	}
	
	@Test
	@DisplayName("Testing the largest method also checks for exception handling")
	void testLargest() {
		try {
			assertEquals(firstTestObject.largest(), 7890);
			assertEquals(secondTestObject.largest(), 751);
			
			firstTestObject.clear();
			firstTestObject.largest();
			
		} catch (CustomException e) {
			assertEquals("An empty set can't have largest element!", e.getMessage());
		}
		
	}

	@Test
	@DisplayName("Testing the smallest method, also checks for exception handling")
	void testSmallest() {
		try {
			assertEquals(secondTestObject.smallest(), -1234);
			assertEquals(firstTestObject.smallest(), -12);
			
			secondTestObject.clear();
			secondTestObject.smallest();
			
		} catch (CustomException e) {
			assertEquals("An empty set can't have smallest element!", e.getMessage());
		}
			
	}
	

	//firstTestObject = {213, -12, 7, 7890}
	//secondTestObject = {1, 25, 751, 12, 76, -1234}
	@Test
	@DisplayName("Testing the union method")
	void testUnion() {
		
		//checking if union takes duplicates
		secondTestObject.add(-12);
		
		int[] arr3 = {213, -12, 7, 7890, 1, 25, 751, 12, 76, -1234};
		
		for (int i = 0; i < arr3.length; i++) {
			testSet.add(arr3[i]);
			
		}
		firstTestObject.union(secondTestObject);
		assertEquals(firstTestObject.getSet(), testSet);
		
		secondTestObject.union(firstTestObject);
		assertEquals(firstTestObject.getSet(), testSet);
		
		//when one of the IntegerSet objects is empty
		firstTestObject.clear();
		firstTestObject.union(secondTestObject);
		testSet.clear();
		
		int[] arr8 = {1, 25, 751, 12, 76, -1234, -12, 213, 7, 7890};
		
		for (int i = 0; i < arr8.length; i++) {
			testSet.add(arr8[i]);
		}
	
		assertEquals(firstTestObject.getSet(), testSet);
		
	}
	
	@Test
	@DisplayName("Testing the intersection method")
	void testIntersection() {
		
		
		//firstTestObject = {213, -12, 7, 7890}
		//secondTestObject = {1, 25, 751, 12, 76, -1234}
		
		
		//adding some elements to make sure there is atleast something in common
		
		secondTestObject.add(213);
		secondTestObject.add(7890);
		
		firstTestObject.add(25);
		firstTestObject.add(12);
		

		firstTestObject.intersect(secondTestObject);
		secondTestObject.intersect(firstTestObject);
		
	
		int[] arr4 = {213, 7890, 25, 12};
		
		for (int i = 0; i < arr4.length; i++) {
			testSet.add(arr4[i]);
			
		}
		
		assertEquals(firstTestObject.getSet(), testSet);
		
		testSet.clear();
		
		int[] arr5 = {25,12, 213, 7890};
		
		for (int i = 0; i < arr5.length; i++) {
			testSet.add(arr5[i]);
		}
		
		assertEquals(secondTestObject.getSet(), testSet);
		
		
		//when no elements are common between two IntegerSets
		firstTestObject.clear();
		firstTestObject.intersect(secondTestObject);
		testSet.clear();
		assertEquals(firstTestObject.getSet(), testSet);


	}
	
	@Test

	@DisplayName("Testing the difference method")
	void testDifference() {
		//firstTestObject = {213, -12, 7, 7890}
		//secondTestObject = {1, 25, 751, 12, 76, -1234}
		
		firstTestObject.diff(secondTestObject);
		secondTestObject.diff(firstTestObject);
		
		int[] arr6 = {213, -12, 7, 7890};
		
		for (int i = 0; i < arr6.length; i++) {
			testSet.add(arr6[i]);
		}
		
		assertEquals(firstTestObject.getSet(), testSet);
		testSet.clear();
		
		int[] arr7 = {1, 25, 751, 12, 76, -1234};
		
		for (int i = 0; i < arr7.length; i++) {
			testSet.add(arr7[i]);
		}
	
		assertEquals(secondTestObject.getSet(), testSet);
		
		testSet.clear();
		firstTestObject.clear();
		firstTestObject.diff(secondTestObject);
		assertEquals(firstTestObject.getSet(), testSet);
		
	}
	
	@Test
	@DisplayName("Testing the isEmpty method")
	void testIsEmpty() {
		assertEquals(firstTestObject.isEmpty(), false);

		assertEquals(secondTestObject.isEmpty(), false);
		
		firstTestObject.clear();
		assertTrue(firstTestObject.isEmpty());
	}
		
	@Test
	@DisplayName("Testing the toString method")
	void testToString() {
		int[] arr6 = {213, -12, 7, 7890};
		
		for (int i = 0; i < arr6.length; i++) {
			testSet.add(arr6[i]);
		}
		
		assertEquals(firstTestObject.toString(), testSet.toString());
		testSet.clear();
		
		int[] arr7 = {1, 25, 751, 12, 76, -1234};
		
		for (int i = 0; i < arr7.length; i++) {
			testSet.add(arr7[i]);
		}
		
		assertEquals(secondTestObject.toString(), testSet.toString());
	
	}
	


}
