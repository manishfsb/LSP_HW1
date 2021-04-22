package org.howard.edu.lsp.assignment6.integerset;

import java.util.ArrayList;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution solution = new Solution();
		
		ArrayList<Integer> b = new ArrayList<>();
//		b.add(0);
//		b.add(0);b.add(0);b.add(0);
//		b.add(0);
//		b.add(0);
//		b.add(0);
		
		
		solution.removeZeros(b);
		
		System.out.println(b);
	}
//
//	Test cases: empty, given example, all zeros
}
