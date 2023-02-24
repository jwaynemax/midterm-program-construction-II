package edu.westga.cs6311.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6311.model.Boeing737;

class TestBoeing737 {
	private Boeing737 boeing737;

	@BeforeEach
	void setUp() throws Exception {
		this.boeing737 = new Boeing737();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.boeing737 = null;
	}

	@Test
	void testValidConstructor() {
		assertEquals("Boeing", this.boeing737.getMake(), "Testing Boeing737 Constructor");
	}
	
	@Test
	void testFlyNoParam() {
		assertEquals("Plane's Current Speed: 1.0, Plane's Current Direction North", this.boeing737.fly(), "Testing Boeing737 fly w/ no params");
	}
	
	@Test
	void testFlyWithParam() {
		assertEquals("Plane's Current Speed: 1.0, Plane's Current Direction East", this.boeing737.fly(1.0, "East"), "Testing Boeing737 fly w/ params");
	}
	
	@Test
	void testEngineHoursWithFlyNoParam() {
		
		this.boeing737.setPassengerCapacity(131);
		this.boeing737.fly();
		
		assertEquals(3.0, this.boeing737.getEngineHours(), "Testing Boeing737 Engine Hours w/ capcity > 65% of total");
	}
	
	@Test
	void testFlyAddThreeToEngineHours() {
		this.boeing737.setCurrentSpeed(20);
		this.boeing737.setPassengerCapacity(1);
		this.boeing737.fly(4, "East");
		assertEquals(2.0, this.boeing737.getEngineHours(), "Testing Boeing737 fly w/ current speed < 20% of max speed and current capacity < 35% total capacity and acceleration > 3");
	}
	
	@Test
	void testFlyAddFourToEngineHours() {
		this.boeing737.setPassengerCapacity(189);
		this.boeing737.fly(4, "East");
		assertEquals(4.0, this.boeing737.getEngineHours(), "Testing Boeing737 fly w/ current capacity > 90% total capacity and acceleration > 1");
	}

	@Test 
	void testServiceRequired() {
		this.boeing737.setEngineHours(501);
		assertEquals(true, this.boeing737.serviceRequired(), "Testing boeing737 Service Required");
	}
	
	@Test
	void testErrorSetPassengerCapacity() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.boeing737.setPassengerCapacity(201);
		});
	}
	
	@Test
	void testErrorSetTotalPassengerCapacity() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.boeing737.setTotalPassengerCapacity(-1);
		});
	}
}
