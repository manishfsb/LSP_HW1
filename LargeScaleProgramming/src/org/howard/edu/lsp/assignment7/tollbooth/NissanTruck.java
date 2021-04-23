package org.howard.edu.lsp.assignment7.tollbooth;

public class NissanTruck extends Truck{
	
	NissanTruck(int NumberAxles, int TruckWeight){
		super(NumberAxles, TruckWeight);
	}
	
	public static void main(String [] args) {
		Truck nissan = new NissanTruck(2, 5000);
		System.out.println(nissan.getAxles());
	}

}
