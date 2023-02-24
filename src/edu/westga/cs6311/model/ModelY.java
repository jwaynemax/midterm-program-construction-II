/**
 * 
 */
package edu.westga.cs6311.model;

/**
 * Define ModelY Object - extends Car
 * @author justinmaxwell
 * @version 2/22/23
 */
public class ModelY extends Car {
	
	/**
	 * Constructor
	 */
	public ModelY() {
		super.setMake("Tesla");
		super.setModel("Model Y");
		super.setWeight(4000);
		super.setBodyStyle("SUV");
		super.setCurrentSpeed(0);
		super.setMaximumSpeed(145);
		super.setDirection("North");
		super.setEngineHours(0);
	}
	
	/**
	 * Accelerate car, set engine hours
	 * @precondition if speed > 85, increment engine hours by 2 else increment by 1
	 * @return string w/ current speed and current direction
	 */
	@Override
	public String drive() {
		this.accelerate();
		if (super.getCurrentSpeed() > 85.0) {
			super.setEngineHours(super.getEngineHours() + 2);
		} else {
			super.setEngineHours(super.getEngineHours() + 1);
		}
		return "Car's Current Speed: " + super.getCurrentSpeed() + ", Car's Current Direction " + super.getDirection();	
	}
	
	/**
	 * Overload drive to accept acceleration and direction
	 * @param acceleration
	 * @param direction
	 * @return speed and direction
	 */
	public String drive(double acceleration, String direction) {
		super.setDirection(direction);
		super.setCurrentSpeed(super.getCurrentSpeed() + acceleration);
		
		if (acceleration > 5 && super.getCurrentSpeed() < (.20 * super.getMaximumSpeed())) {
			super.setEngineHours(super.getEngineHours() + 2);
		} else if (acceleration > 2 && super.getCurrentSpeed() > (.60 * super.getMaximumSpeed())) {
			super.setEngineHours(super.getEngineHours() + 3);
		} else {
			super.setEngineHours(super.getEngineHours() + 1);
		}
		
		return "Car's Current Speed: " + super.getCurrentSpeed() + ", Car's Current Direction " + super.getDirection();
	}
	
	/**
	 * implements serviceRequired from MotorizedVehicle
	 */
	@Override
	public boolean serviceRequired() {
		boolean var = false;
		if (super.getEngineHours() >= 8064) {
			var = true;
		}
		return var;
	}
}
