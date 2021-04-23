package org.howard.edu.lsp.assignment7.tollbooth;

public class FordTruck extends Truck{

	FordTruck(int Axles, int truckWeight) {
		super(Axles, truckWeight);
		
	}

public static void main(String [] args) {
	Truck ford = new FordTruck(5, 12000);
	
	//testing the Setter method in truck class
	ford.setWeight(20000);

	System.out.println(ford.getWeight());
}

}
