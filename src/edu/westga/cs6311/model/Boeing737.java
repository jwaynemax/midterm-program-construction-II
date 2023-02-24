/**
 * 
 */
package edu.westga.cs6311.model;

/**
* Define 737 Object - extends Plane
* @author justinmaxwell
* @version 2/22/23
*/
public class Boeing737 extends Plane {
	
	/**
	 * Constructor
	 */
	public Boeing737() {
		super.setMake("Boeing");
		super.setModel("737");
		super.setPassengerCapacity(0);
		super.setTotalPassengerCapacity(200);
		super.setCurrentSpeed(0);
		super.setMaximumSpeed(145);
		super.setDirection("North");
		super.setEngineHours(0);
	}
	
	/**
	 * Accelerate plane, set engine hours
	 * @precondition if passenger capacity > 65% of total capacity, increment engine hours by 3 else increment by 1
	 * @return string w/ current speed and current direction
	 */
	@Override
	public String fly() {
		if (this.serviceRequired() == true) {
			return super.getErrorCode("004");
		} else {
			this.accelerate();
			if (super.getPassengerCapacity() > (.65 * super.getTotalPassangerCapacity())) {
				super.setEngineHours(super.getEngineHours() + 3);
			} else {
				super.setEngineHours(super.getEngineHours() + 1);
			}
			return "Plane's Current Speed: " + super.getCurrentSpeed() + ", Plane's Current Direction " + super.getDirection();	
		}
	}
	
	/**
	 * Overload fly to accept acceleration and direction
	 * @param acceleration
	 * @param direction
	 * @return speed and direction
	 */
	public String fly(double acceleration, String direction) {
		super.setDirection(direction);
		super.setCurrentSpeed(super.getCurrentSpeed() + acceleration);
		
		if (acceleration > 3 && super.getCurrentSpeed() < (.20 * super.getMaximumSpeed()) && super.getPassengerCapacity() < (.35 * super.getTotalPassangerCapacity())) {
			super.setEngineHours(super.getEngineHours() + 2);
		} else if (acceleration > 1 && super.getCurrentSpeed() > (.60 * super.getMaximumSpeed()) || super.getPassengerCapacity() > (.90 * super.getTotalPassangerCapacity())) {
			super.setEngineHours(super.getEngineHours() + 4);
		} else {
			super.setEngineHours(super.getEngineHours() + 1);
		}
		
		return "Plane's Current Speed: " + super.getCurrentSpeed() + ", Plane's Current Direction " + super.getDirection();
	}
	
	/**
	 * implements serviceRequired from MotorizedVehicle
	 */
	@Override
	public boolean serviceRequired() {
		boolean var = false;
		if (super.getEngineHours() >= 500) {
			var = true;
		}
		return var;
	}
}
