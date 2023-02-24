package edu.westga.cs6311.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6311.model.Boeing737;
import edu.westga.cs6311.model.ModelY;
import edu.westga.cs6311.model.R35;

class TestErrorCodes {
	private ModelY modely;
	private R35 r35;
	private Boeing737 boeing737;

	@BeforeEach
	void setUp() throws Exception {
		this.modely = new ModelY();
		this.r35 = new R35();
		this.boeing737 = new Boeing737();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.modely = null;
		this.r35 = null;
		this.boeing737 = null;
	}


	
	@Test 
	void testGetSpecificErrorCode() {
		assertEquals("maximumSpeed can not be negative or greater than 150.", this.modely.getErrorCode("001"), "Testing Model Y Error Codes");
	}
	
	@Test 
	void testAddErrorCode() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.boeing737.setEngineHours(-1);
		});	
	}
	
	@Test 
	void testRemoveErrorCode() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.r35.setEngineHours(-1);
		});
		
		this.r35.setEngineHours(1.0);
		
		assertEquals(1.0, this.r35.getEngineHours(), "Testing Throwing Error Code and Removing Error Code on R35");
	}

}
