package org.howard.edu.lsp.assignment4.implementation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author manishbasnet
 * IntegerSet, using ArrayList enables an object to have set-like attributes like storing unique values and so on.	
 * Also provides methods to perform set operations like union, intersection and difference 
 */

public class IntegerSet {

		private ArrayList<Integer> set = new ArrayList<>();
		
		
		/**
		 * 
		 * @return the ArrayList 'set' which we will reference to use ArrayList methods 
		 */
		public ArrayList<Integer> getSet() {
			return this.set;
		}
		
		/**
		 * empties the IntegerSet, utilizing the ArrayList method to clear the list
		 */
		public void clear() {
			this.getSet().clear();
		}
		
		/**
		 * 
		 * @return length of the IntegerSet, utilizing the method to get size of an ArrayList
		 */
		public int length() {
			return this.getSet().size();
				}
		
		
		/**
		 * 
		 * @param b of type IntegerSet
		 * @return true if two sets have the same elements in any order, else false
		 */
		public boolean equals(IntegerSet b) {
			if (b.length() != this.length()){
				return false;	
			}
			
			//sorting the two ArrayLists and then checking each index 
			Collections.sort(this.getSet());
			Collections.sort(b.getSet());
			
			for (int index = 0; index < b.length(); index ++) {
				if (b.getSet().get(index) != this.getSet().get(index)) {
					return false;
				}
				
			}
			return true;
			
		}
		
		/**
		 * 
		 * @param value of type integer 
		 * @return true if the IntegerSet contains the value, else false 
		 */
		
		public boolean contains(int value) {
			return this.getSet().contains(value);
		}
		
		/**
		 * 
		 * @return the largest element in the IntegerSet
		 * @throws CustomException if the IntegerSet is empty
		 */
		public int largest() throws CustomException{
			
			//initializing the integer greatest to - infinity to make sure there are larger elements in the IntegerSet
			int greatest = (int) Float.NEGATIVE_INFINITY;
			

//			throw exception if the set is empty
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
		
		/**
		 * 
		 * @return the smallest element in the IntegerSet
		 * @throws CustomException if the IntegerSet is empty
		 */
		public int smallest() throws CustomException {
			int least = (int) Float.POSITIVE_INFINITY;
			

//			throw exception if empty
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
		
		/**
		 * @param item of type int 
		 * if item is not in the set, add item
		 */
		public void add(int item) {
			if (!this.getSet().contains(item)){
				this.getSet().add(item);
				
			}
		}
		
		/**
		 * 
		 * @param item of type int
		 * if item is in the set, remove
		 */
		public void remove(int item) {
			if (this.contains(item)) {
				this.getSet().remove(this.getSet().indexOf(item));
			}
		}
		
		/**
		 * @param intSetb of type IntegerSet
		 * adds the elements of intSetb to the object that called the method, while still maintaining unique values 
		 */
		public void union(IntegerSet intSetb) {
			if (!this.equals(intSetb)) {
				
				for (int bIndex = 0; bIndex < intSetb.getSet().size(); bIndex ++) {
					this.add(intSetb.getSet().get(bIndex));
				}	
			}
		}
		
		/**
		 * 
		 * @param intSetb of type IntegerSet
		 * changes the elements of the object calling the method to contain values that are in both sets
		 */
		public void intersect(IntegerSet intSetb) {
			
			int i = 0;
			while (i <getSet().size()) {
				Integer j = getSet().get(i);
				if (!intSetb.contains(j)) {
					getSet().remove(j);
				} 
				
				else {
					i ++;
				}
			}
		}
		
		/**
		 * 
		 * @param intSetb of type IntegerSet
		 * changes the elements of the object calling the method to the elements in the object but not in intSetb
		 */
		public void diff(IntegerSet intSetb) {
			
			if (!equals(intSetb)) {
			int i = 0;
				while (i <getSet().size()) {
					Integer j = getSet().get(i);
					
					if (intSetb.contains(j)) {
						getSet().remove(j);
					}
					
					else {
						i ++;
					}
				}
			}
			
		}
			
		/**
		 * 
		 * @return true if the set is empty, else false
		 */
		public boolean isEmpty() {
			return this.getSet().isEmpty();
		}
		
		/**
		 * @return the string representation of the set
		 */
		public String toString() {
			return this.getSet().toString();
		}
	
	}
		

	





