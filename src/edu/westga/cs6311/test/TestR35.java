package edu.westga.cs6311.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6311.model.R35;

class TestR35 {
	private R35 r35;

	@BeforeEach
	void setUp() throws Exception {
		this.r35 = new R35();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.r35 = null;
	}

	@Test
	void testValidConstructor() {
		assertEquals("R35", this.r35.getModel(), "Testing R35 Constructor");
	}
	
	@Test
	void testSailNoParam() {
		assertEquals("Boat's Current Speed: 1.0, Boat's Current Direction North", this.r35.sail(), "Testing R35 Sail w/ no params");
	}
	
	@Test
	void testSailAndEngineHours() {
		this.r35.setCurrentCapacity(5);
		this.r35.sail();
		
		assertEquals(2, this.r35.getEngineHours(), "Testing R35 Sail w/ current capacity > 40% of total capacity");
	}
	
	@Test
	void testSailWithParam() {
		assertEquals("Boat's Current Speed: 1.0, Boat's Current Direction East", this.r35.sail(1, "East"), "Testing R35 Sail w/ params");
	}
	
	@Test
	void testSailAddTwoToEngineHours() {
		this.r35.setCurrentSpeed(20);
		this.r35.setCurrentCapacity(1);
		this.r35.sail(4, "East");
		assertEquals(2.0, this.r35.getEngineHours(), "Testing R35 Sail w/ current speed < 20% of max speed and current capacity < 35% total capacity and acceleration > 3");
	}
	
	@Test
	void testSailAddThreeToEngineHours() {
		this.r35.setCurrentSpeed(89);
		this.r35.sail(2, "East");
		assertEquals(3.0, this.r35.getEngineHours(), "Testing R35 Sail w/ current speed > 60% of max speed w/ OR condition");
	}
	
	@Test 
	void testServiceRequired() {
		this.r35.setEngineHours(4033);
		assertEquals(true, this.r35.serviceRequired(), "Testing R35 Service Required");
	}
}
