package org.howard.edu.lsp.exam.question40;

public class Goose extends FlyingObject{
	
	/**
	 * Overloading the default methods of Animal interface
	 */
	@Override
	public String move(){
		return "This Goose moves forward";
	}
	
	@Override
	public String speak() {
		return "This Goose speaks";
	}
	
	/**
	 * Chose a different behavior from Airplane because that's what abstract classes are for
	 */
	public String fly() {
		return "This goose flies but not as high as the airplane";
	}
	
}
