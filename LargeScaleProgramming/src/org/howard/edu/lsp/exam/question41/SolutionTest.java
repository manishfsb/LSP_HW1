package org.howard.edu.lsp.exam.question41;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {
	
	Solution solution;
	ArrayList<Integer> testList;
	ArrayList<Integer> expectedList;
	
	@BeforeEach
	@DisplayName("creating new Solution object, an arraylist and expectedList to verify correctness of our method removeZeros")
	public void setUp() {
		solution = new Solution();
		testList = new ArrayList<>();
		expectedList = new ArrayList<>();
			
	}
	@Test
	@DisplayName("testing the removeZeros method with example provided in the question")
	public void testExample() {
		testList.add(0);
		testList.add(7);
		testList.add(2);
		testList.add(0);
		testList.add(0);
		testList.add(4);
		testList.add(0);
		
		int[] example = { 7, 2, 4};
		
		for (int i = 0; i < example.length; i ++) {
			expectedList.add(example[i]);
		}
		
		solution.removeZeros(testList);
		
		assertEquals(testList, expectedList);
		
	}
	
	@Test
	@DisplayName("testing the removeZeros method with similar input to example provided in the question")
	public void testSimilartoExample() {
		testList.add(1);
		testList.add(7);
		testList.add(2);
		testList.add(0);
		testList.add(0);
		testList.add(4);
		testList.add(99);
		testList.add(10031);
		testList.add(-99);
		testList.add(4);
		testList.add(99);
		
		int[] example = { 1, 7, 2, 4, 99, 10031, -99, 4, 99};
		
		for (int i = 0; i < example.length; i ++) {
			expectedList.add(example[i]);
		}
		
		solution.removeZeros(testList);
		
		assertEquals(testList, expectedList);
		
	}

	
	@Test
	@DisplayName("testing the removeZeros method with input with all zeros")
	public void testAllZeros() {
		testList.add(0);
		testList.add(0);
		testList.add(0);
		testList.add(0);
		testList.add(0);
		testList.add(0);
		testList.add(0);
		
		
		solution.removeZeros(testList);
		
		assertEquals(testList, expectedList);
		
	}
	
	@Test
	@DisplayName("testing the removeZeros method with input with no zeros")
	public void testNoZeros() {
		testList.add(1);
		testList.add(7);
		testList.add(2);
		testList.add(-1231);
		testList.add(3123);
		testList.add(4);
		testList.add(-123);
		
		int[] example = {1, 7, 2, -1231, 3123, 4, -123};
		
		for (int i = 0; i < example.length; i ++) {
			expectedList.add(example[i]);
		}
		
		solution.removeZeros(testList);
		
		assertEquals(testList, expectedList);
		
	}



}
