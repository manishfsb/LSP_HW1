package org.howard.edu.lsp.assignment7.tollbooth;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 100;
		int b = 20;
		double c = 2.10;
		String truckTotal = String.format("Truck arrival - Axles: %d Total weight: %d Toll due: %f", a, b, c);
		System.out.println(truckTotal);
	}

}
