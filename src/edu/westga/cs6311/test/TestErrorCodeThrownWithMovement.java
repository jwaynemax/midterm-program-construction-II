package edu.westga.cs6311.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.westga.cs6311.model.Boeing737;
import edu.westga.cs6311.model.ModelY;
import edu.westga.cs6311.model.R35;

class TestErrorCodeThrownWithMovement {

	@Test
	void testErrorCodeThrownWhenSailing() {
		R35 boat = new R35();
		
		assertEquals("Cannot accelerate boat beyond maximum speed.", boat.sail(155, "North"), "Testing error thrown when attempting to acceleratee beyond max speed when Sailing");
	}
	
	@Test
	void testErrorCodeThrownWhenDriving() {
		ModelY car = new ModelY();
		
		assertEquals("Cannot travel this direction. Can only travel - North, South, East, or West.", car.drive(155, "southeast"), "Testing error thrown when attempting to specify invalid direction");
	}
	
	@Test
	void testErrorCodeThrownWhenFlying() {
		Boeing737 plane = new Boeing737();
		
		plane.setEngineHours(5000);
		
		assertEquals("Service Required. Cannot fly.", plane.fly(), "Testing error thrown when attempting to fly when service is required");
	}

}