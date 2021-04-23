package org.howard.edu.lsp.assignment7.tollbooth;

public class AlleghenyTollBooth implements TollBooth {
	// 5 per axle, 10 per 500kgs ( half metric ton)
	private int numberOfTrucks;
	private int totalReceipts;
	
	
	@Override
	public void calculateToll(Truck truck) {
		double totalTruck  = (5 * truck.getAxles()) + (10 * (truck.getWeight() / 500));  
		
		numberOfTrucks += 1;
		totalReceipts += totalTruck;
		String truckTotal = "Truck arrival - Axles: " + truck.getAxles() + " Total weight: " + truck.getWeight() + " Toll due: " + totalTruck;
		System.out.println(truckTotal);
	}

	@Override
	public void displayData() {
		String display = "Totals since last collection - Receipts: " + totalReceipts + " Trucks: " + numberOfTrucks;
		System.out.println(display);
	}

	@Override
	public void reset() {
		String onReset = "***Collecting receipts ***\nTotals since last collection - Receipts: " + totalReceipts + " Trucks: " + numberOfTrucks ;
		
		totalReceipts = 0;
		numberOfTrucks = 0;
		System.out.println(onReset);
	}
	
	@Override
	public int getNumberTrucks() {
		return numberOfTrucks;
	}
	
	@Override
	public int getTotalReceipts() {
		return totalReceipts;
	}
	
	
	public static void main(String [] args) {
		TollBooth booth = new AlleghenyTollBooth();
		
		Truck ford = new FordTruck(5, 8000);
		Truck nissan = new NissanTruck(6, 5000); 	// 2 axles and 5000kg
		
		booth.calculateToll(ford);
		booth.displayData();
		
		booth.calculateToll(nissan);
		booth.displayData();
		
		booth.reset();
		booth.displayData();
		
		
	}

}
