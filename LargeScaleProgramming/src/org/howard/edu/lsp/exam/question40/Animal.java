package org.howard.edu.lsp.exam.question40;

public interface Animal {
	/**
	 * Default behavior speak
	 */
	default public String speak() {
		return "This animal speaks";
	}
	
	/**
	 * Default behavior move
	 */
	default public String move() {
		return "This animal moves forward";
	}
	
}	
