package org.howard.edu.lsp.assignment7.tollbooth;

public abstract class Truck {
	private int axle;
	private int weight;
	
	public Truck(int numberOfAxles, int truckWeight) {
		this.axle = numberOfAxles;
		this.weight = truckWeight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int value) {
		this.weight = value;
	}
	
	public int getAxles() {
		return this.axle;
	}
	
	public void setAxles(int value) {
		this.axle = value;
	}
}

