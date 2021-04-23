package org.howard.edu.lsp.assignment7.tollbooth;

public abstract class Truck {
	private int axle;
	private int weight;
	
	public Truck(int numberOfAxles, int truckWeight) {
		this.axle = numberOfAxles;
		this.weight = truckWeight;
	}
	
	int getWeight() {
		return this.weight;
	}
	
	void setWeight(int value) {
		this.weight = value;
	}
	
	int getAxles() {
		return this.axle;
	}
	
	void setAxles(int value) {
		this.axle = value;
	}
}

