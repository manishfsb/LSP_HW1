package org.howard.edu.lsp.exam.question40;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AirplaneTest {

	@Test
	void test() {
		//variables can be stored as type flyingObject
		FlyingObject airplane = new Airplane();
		assertEquals(airplane.fly(), "This plane flies high");
		
		System.out.println(airplane.speak());
	}

}
