package org.howard.edu.lsp.assignment7.tollbooth;

public interface TollBooth {
	public void calculateToll(Truck truck);
	public void displayData();
	public void reset();
	public int getNumberTrucks();
	public int getTotalReceipts();

}
