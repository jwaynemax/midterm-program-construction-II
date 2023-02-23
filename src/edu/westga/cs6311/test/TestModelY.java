/**
 * 
 */
package edu.westga.cs6311.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6311.model.ModelY;

/**
 * @author justinmaxwell
 * @version 2/22/23
 */
class TestModelY {
	private ModelY modely;

	
	@BeforeEach
	void setUp() throws Exception {
		this.modely = new ModelY();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.modely = null;
	}

	@Test
	void testValidConstructor() {
		assertEquals("Tesla", this.modely.getMake(), "Testing Model Y Constructor");
	}
	
	@Test
	void testDriveNoParam() {
		assertEquals("Car's Current Speed: 1.0, Car's Current Direction North", this.modely.drive(), "Testing Model Y Drive w/ no params");
	}
	
	@Test
	void testDriveWithParam() {
		assertEquals("Car's Current Speed: 2.0, Car's Current Direction East", this.modely.drive(2.0, "East"), "Testing Model Y Drive w/ param");
	}
	
	@Test
	void testEngineHoursWithDriveNoParam() {
		
		this.modely.setCurrentSpeed(86.0);
		this.modely.drive();
		
		assertEquals(2.0, this.modely.getEngineHours(), "Testing Model Y Engine Hours w/ Current Speed > 85");
	}
	
	@Test
	void testEngineHoursWithDriveAndParamAccelerateGreater5() {
		
		this.modely.setCurrentSpeed(18.0);
		this.modely.drive(6, "East");
		
		assertEquals(2.0, this.modely.getEngineHours(), "Testing Model Y Drive w/ acceleration > 5 and current speed < 20% of max speed");
	}
	
	@Test
	void testEngineHoursWithDriveAndParamAccelerateGreater2() {
		
		this.modely.setCurrentSpeed(89.0);
		this.modely.drive(3, "East");
		
		assertEquals(3.0, this.modely.getEngineHours(), "Testing Model Y Drive w/ acceleration > 2 and current speed > 60% of max speed");
	}
	
	@Test 
	void testServiceRequired() {
		this.modely.setEngineHours(9000);
		assertEquals(true, this.modely.serviceRequired(), "Testing Model Y Service Required");
	}

}
