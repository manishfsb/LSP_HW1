package org.howard.edu.lsp.assignment4.implementation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author manishbasnet
 *
 */

public class IntegerSet {

		private ArrayList<Integer> set = new ArrayList<>();
		
		
		
		/**
		 * 
		 * @return
		 */
		
		public ArrayList<Integer> getSet() {
			return this.set;
		}
		
		/**
		 * 
		 * 
		 */
		public void clear() {
			this.getSet().clear();
		}
			
		public int length() {
			return this.getSet().size();
				}
		
		
		public boolean equals(IntegerSet b) {
			//in case each element in the two arrays are the same
			
			if (b.length() != this.length()){
				return false;	
			}
			
			Collections.sort(this.getSet());
			Collections.sort(b.getSet());
			
			for (int index = 0; index < b.length(); index ++) {
				if (b.getSet().get(index) != this.getSet().get(index)) {
					return false;
				}
				
			}
			return true;
			
		}
		
		public boolean contains(int value) {
			if (this.getSet().contains(value)){
			return true;
			}
			
			return false;
			
		}
		
//		throw exception if the set is empty
		public int largest() throws CustomException{
			
			int greatest = (int) Float.NEGATIVE_INFINITY; 
			if (this.isEmpty()){
				throw new CustomException("An empty set can't have largest element!");
				
			}
			
			else {
				for (int i = 0; i < getSet().size(); i ++) {
					if (this.getSet().get(i) > greatest) {
						greatest = getSet().get(i) ; 
					}
				}
				
				return greatest;
				
			}
		
		}
		
//		throw exception if empty
		public int smallest() throws CustomException {
			int least = (int) Float.POSITIVE_INFINITY;
			if (this.isEmpty()) {
				throw new CustomException("An empty set can't have smallest element!");
			}
			
			else {
				
				for (int i = 0; i < this.getSet().size(); i ++) {
					if (this.getSet().get(i) < least) {
						least = this.getSet().get(i) ; 
					}
				}
				
				return least;
			}			
		}
		
		public void add(int item) {
			if (!this.getSet().contains(item)){
				this.getSet().add(item);
				
			}
		}
		
		public void remove(int item) {
			if (this.set.contains(item)) {
				Integer item1 = item;
				this.set.remove(item1);
			}
		}
		
		public void union(IntegerSet intSetb) {
			if (!this.equals(intSetb)) {
				
			for (int bIndex = 0; bIndex < intSetb.getSet().size(); bIndex ++) {
				this.add(intSetb.getSet().get(bIndex));
			}	
		}
		}
		
		public void intersect(IntegerSet intSetb) {
			
			if (!this.equals(intSetb)) {
				
				for (int bIndex = 0; bIndex < this.getSet().size(); bIndex ++) {
					int elem = this.getSet().get(bIndex);

					if (!intSetb.contains(elem)) {
						this.remove(elem);
					}
				}	
		}
		}
		
		public void diff(IntegerSet intSetb) {
			
			if (!this.equals(intSetb)){
		
				for (int j : this.getSet()) {
					if (intSetb.contains(j)) {
						this.remove(j);
					}
				}
			}	
			
		}
			
		public boolean isEmpty() {
			return this.getSet().isEmpty();
		}
		
		public String toString() {
			return this.set.toString();
		}
	
	}
		

	





