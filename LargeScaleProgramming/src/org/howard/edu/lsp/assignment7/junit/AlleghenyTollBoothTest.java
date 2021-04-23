package org.howard.edu.lsp.assignment7.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.assignment7.tollbooth.AlleghenyTollBooth;
import org.howard.edu.lsp.assignment7.tollbooth.FordTruck;
import org.howard.edu.lsp.assignment7.tollbooth.NissanTruck;
import org.howard.edu.lsp.assignment7.tollbooth.TollBooth;
import org.howard.edu.lsp.assignment7.tollbooth.Truck;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlleghenyTollBoothTest {
	
	Truck nissan;
	Truck secondNissan;
	Truck secondFord;
	TollBooth booth;
	Truck ford;

	@BeforeEach
	void setUp() throws Exception {
		booth = new AlleghenyTollBooth();
		ford = new FordTruck(5, 12000);
		nissan = new NissanTruck(2, 5000);
		
		secondFord = new FordTruck(1, 500);
		secondNissan = new NissanTruck(6, 123131);
		
	}

	@Test
	void testTrucks() {
		assertEquals(ford.getAxles(), 5);
		assertEquals(nissan.getAxles(), 2);
		
		assertEquals(ford.getWeight(), 12000);
		assertEquals(nissan.getWeight(), 5000);
		
		nissan.setAxles(6);
		ford.setWeight(8000);
		
		assertEquals(ford.getWeight(), 8000);
		assertEquals(nissan.getAxles(), 6);
		
		
//		
//		booth.calculateToll(ford);
//		booth.displayData();
//		booth.calculateToll(nissan);
//		booth.reset();	// zero out receipts, print out aforementioned summary information.
//		
//		booth.displayData();	
//
//		;
	}
	
	@Test
	@DisplayName("Testing basic booth methods")
	void testBooth() {

		assertEquals(booth.getNumberTrucks(), 0);
		
		//toll should be 265
		booth.calculateToll(ford);
		assertEquals(booth.getNumberTrucks(), 1);
		assertEquals(booth.getTotalReceipts(), 265);
		
		//toll should be 110
		booth.calculateToll(nissan);
		
		// 1 added to Number of trucks and 110 the toll of the first nissan truck added to receipt
		assertEquals(booth.getNumberTrucks(), 2);
		assertEquals(booth.getTotalReceipts(), 265 + 110);
		
		booth.displayData();
		assertEquals(booth.getNumberTrucks(), 2);
		assertEquals(booth.getTotalReceipts(), 265 + 110);
		
		//toll for secondFord  = 15
		booth.calculateToll(secondFord);
		
		//toll for secondNissan = 2490
		booth.calculateToll(secondNissan);
		
		assertEquals(booth.getNumberTrucks(), 4);
		assertEquals(booth.getTotalReceipts(), 265 + 110 + 15 + 2490);
		
		booth.reset();
		assertEquals(booth.getNumberTrucks(), 0);
		assertEquals(booth.getTotalReceipts(), 0);
		
	}
	
		

}
