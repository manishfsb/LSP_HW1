package org.howard.edu.lsp.exam.question40;

public class Tiger implements Animal{
	/**
	 * Overriding the default method move of Animal interface that prints specific tiger actions
	 */
	@Override
	public String move() {
		return "This Tiger moves forward";
	}
	
	/**
	 * Overriding the default method speak that prints specifically about tiger
	 */
	@Override
	public String speak() {
		return "This Tiger speaks";
	}
}
