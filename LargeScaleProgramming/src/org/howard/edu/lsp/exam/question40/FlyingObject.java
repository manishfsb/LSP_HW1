package org.howard.edu.lsp.exam.question40;

/**
 * 
 * @author mnshb
 *choosing an abstract class to leave the implementation to respective sub classes
 *implements Animal so that Goose object that can move and speak can be stored as FlyingObject
 *Since this is an abstract class we don't have to use all the methods in the Animal interface
 */
public abstract class FlyingObject implements Animal {
	
	/**
	 * We leave the fly method behavior to any class that use this class
	 */
	abstract String fly();
	
}
