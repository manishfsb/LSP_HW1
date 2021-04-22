package org.howard.edu.lsp.assignment6.integerset;

import java.util.ArrayList;

public class Solution {
	
	public void removeZeros(ArrayList<Integer> a) {
		int i = 0;
		while (i < a.size()) {
			if (a.get(i) == 0){
				a.remove(i);
			}
			else {
				i ++;
			}
		}
	}

}

