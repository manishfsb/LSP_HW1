package org.howard.edu.lsp.exam.question40;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GooseTest {

	@Test
	void test() {
		//instances of goose can be stored as type flyingObject
		FlyingObject goose = new Goose();
		
		assertEquals(goose.speak(), "This Goose speaks");
		assertEquals(goose.move(), "This Goose moves forward");
		assertEquals(goose.fly(), "This goose flies but not as high as the airplane");
	}

}
