/**
 * 
 */
package edu.westga.cs6311.model;

/**
 * Define R35 Object - extends Boat
 * @author justinmaxwell
 * @version 2/22/23
 */
public class R35 extends Boat {
	
	/**
	 * Constructor
	 */
	public R35() {
		super.setMake("Cobalt");
		super.setModel("R35");
		super.setCurrentCapacity(0);
		super.setTotalCapacity(10);
		super.setCurrentSpeed(0);
		super.setMaximumSpeed(145);
		super.setDirection("North");
		super.setEngineHours(0);
	}
	
	/**
	 * Accelerate boat, set engine hours
	 * @precondition if current capacity > 40% of total capacity, increment engine hours by 2 else increment by 1
	 * @return string w/ current speed and current direction
	 */
	@Override
	public String sail() {
		this.accelerate();
		if (super.getCurrentCapacity() > (.40 * super.getTotalCapacity())) {
			super.setEngineHours(super.getEngineHours() + 2);
		} else {
			super.setEngineHours(super.getEngineHours() + 1);
		}
		return "Boat's Current Speed: " + super.getCurrentSpeed() + ", Boat's Current Direction " + super.getDirection();	
	}
	
	/**
	 * Overload sail to accept acceleration and direction
	 * @param acceleration
	 * @param direction
	 * @return speed and direction
	 */
	public String sail(double acceleration, String direction) {
		
		if (super.getCurrentSpeed() + acceleration > super.getMaximumSpeed()) {
			return super.getErrorCode("004");
		} else {
			super.setDirection(direction);
			super.setCurrentSpeed(super.getCurrentSpeed() + acceleration);
			
			if (acceleration > 3 && super.getCurrentSpeed() < (.20 * super.getMaximumSpeed()) && super.getCurrentCapacity() < (.35 * super.getTotalCapacity())) {
				super.setEngineHours(super.getEngineHours() + 2);
			} else if (acceleration > 1 && super.getCurrentSpeed() > (.60 * super.getMaximumSpeed()) || super.getCurrentCapacity() > (.90 * super.getTotalCapacity())) {
				super.setEngineHours(super.getEngineHours() + 3);
			} else {
				super.setEngineHours(super.getEngineHours() + 1);
			}
			
			return "Boat's Current Speed: " + super.getCurrentSpeed() + ", Boat's Current Direction " + super.getDirection();
		}
	}
	
	/**
	 * implements serviceRequired from MotorizedVehicle
	 */
	@Override
	public boolean serviceRequired() {
		boolean var = false;
		if (super.getEngineHours() >= 4032) {
			var = true;
		}
		return var;
	}
}
