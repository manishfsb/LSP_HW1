package org.howard.edu.lsp.assignment6.integerset;

import java.util.ArrayList;



public class IntegerSet {
	private ArrayList<Integer> set = new ArrayList<>();
	
	
	/**
	 * getter to get the ArrayList we will be using
	 * @return the ArrayList 'set' which we will reference to use ArrayList methods 
	 */
	public ArrayList<Integer> getSet() {
		return this.set;
	}
	
	/**
	 * clears the contents of the set
	 * empties the IntegerSet, utilizing the ArrayList method to clear the list
	 */
	public void clear() {
		this.getSet().clear();
	}
	
	/**
	 * calculates the length of the set
	 * @return length of the IntegerSet, utilizing the method to get size of an ArrayList
	 */
	public int length() {
		return this.getSet().size();
			}
	
	
	/**
	 * checks if two sets are equal
	 * @param b of type IntegerSet
	 * @return true if two sets have the same elements in any order, else false
	 */
	public boolean equals(IntegerSet b) {
		if (b.length() != this.length()){
			return false;	
		}
		
		
		for (int elem: getSet()) {
			if (!b.contains(elem)) {
				return false;
			}
			
		}
		return true;
		
	}
	
	/**
	 * checks if the value is in the set
	 * @param value of type integer 
	 * @return true if the IntegerSet contains the value, else false 
	 */
	
	public boolean contains(int value) {
		return this.getSet().contains(value);
	}
	
	/**
	 * finds largest element in the set
	 * @return the largest element in the IntegerSet
	 * @throws CustomException if the IntegerSet is empty
	 */
	public int largest() throws CustomException{
		
		//initializing the integer greatest to - infinity to make sure there are larger elements in the IntegerSet
		int greatest = (int) Float.NEGATIVE_INFINITY;
		

//		throw exception if the set is empty
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
	 * finds smallest element in the set
	 * @return the smallest element in the IntegerSet
	 * @throws CustomException if the IntegerSet is empty
	 */
	public int smallest() throws CustomException {
		int least = (int) Float.POSITIVE_INFINITY;
		

//		throw exception if empty
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
	 * if item is not in the set, add item
	 * @param item of type int 
	 * 
	 */
	public void add(int item) {
		if (!this.getSet().contains(item)){
			this.getSet().add(item);
			
		}
	}
	
	/**
	 * if item is in the set, remove
	 * @param item of type int
	 * 
	 */
	public void remove(int item) {
		if (this.contains(item)) {
			this.getSet().remove(this.getSet().indexOf(item));
		}
	}
	
	/**
	 * adds the elements of intSetb to the object that called the method, while still maintaining unique values
	 * @param intSetb of type IntegerSet
	 *  
	 */
	public void union(IntegerSet intSetb) {
		if (!this.equals(intSetb)) {
			
			for (int bIndex = 0; bIndex < intSetb.getSet().size(); bIndex ++) {
				this.add(intSetb.getSet().get(bIndex));
			}	
		}
	}
	
	/**
	 * changes the elements of the object calling the method to contain values that are in both sets
	 * @param intSetb of type IntegerSet
	 * 
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
	 * changes the elements of the object calling the method to the elements in the object but not in intSetb
	 * @param intSetb of type IntegerSet
	 * 
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
	 * true if the set is empty, else false
	 * @return true if the set is empty, else false
	 */
	public boolean isEmpty() {
		return this.getSet().isEmpty();
	}
	
	/**
	 * string representation of the set
	 * @return the string representation of the set
	 */
	public String toString() {
		return this.getSet().toString();
	}

}
