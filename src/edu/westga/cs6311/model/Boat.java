/**
 * 
 */
package edu.westga.cs6311.model;

import java.util.HashMap;

/**
 * Abstract class for Boat objects - implements MotorizedVehicle
 * @author justinmaxwell
 * @version 2/22/23
 */
public abstract class Boat implements MotorizedVehicle {
	private String make;
	private String model;
	private int currentCapacity;
	private int totalCapacity;
	private double currentSpeed;
	private double maximumSpeed;
	private String direction;
	private double engineHours;
	
	/**
	 * 0-param constructor
	 */
	protected Boat() {
		
	}
	
	/**
	 * Boat Constructor
	 */
	protected Boat(String make, String model, int currentCapacity, int totalCapacity, double currentSpeed, double maximumSpeed, String direction, double engineHours) {
		this.setMake(make);
		this.setModel(model);
		this.setCurrentCapacity(currentCapacity);
		this.setTotalCapacity(totalCapacity);
		this.setCurrentSpeed(currentSpeed);
		this.setMaximumSpeed(maximumSpeed);
		this.setDirection(direction);
		this.setEngineHours(engineHours);
	}
	
	/**
	 * get model
	 * @return the make
	 */
	public String getMake() {
		return this.make;
	}
	
	/**
	 * set make
	 * @param make the make to set
	 */
	public void setMake(String make) {
		if (make == null || make.equals("") || make.equals(" ")) {
			throw new IllegalArgumentException("make can not be null, empty, or only whitespace.");
		}
		this.make = make;
	}
	
	/**
	 * get model
	 * @return the model
	 */
	public String getModel() {
		return this.model;
	}
	
	/**
	 * set model
	 * @param model the model to set
	 */
	public void setModel(String model) {
		if (model == null || model.equals("") || model.equals(" ")) {
			throw new IllegalArgumentException("model can not be null, empty, or only whitespace.");
		}
		this.model = model;
	}
	
	/**
	 * get currentCapacity
	 * @return the weight
	 */
	public int getCurrentCapacity() {
		return this.currentCapacity;
	}
	/**
	 * set currentCapacity
	 * @param currentCapacity the currentCapacity to set
	 */
	public void setCurrentCapacity(int currentCapacity) {
		if (currentCapacity < 0) {
			throw new IllegalArgumentException("currentCapacity can not be negative.");
		}
		
		if (currentCapacity > this.getTotalCapacity()) {
			throw new IllegalArgumentException("currentCapacity can not exceed total capacity.");
		}
		this.currentCapacity = currentCapacity;
	}
	
	/**
	 * get totalCapacity
	 * @return the totalCapacity
	 */
	public int getTotalCapacity() {
		return this.totalCapacity;
	}
	
	/**
	 * set totalCapacity
	 * @param totalCapacity the totalCapacity to set
	 */
	public void setTotalCapacity(int totalCapacity) {
		if (totalCapacity < 0) {
			throw new IllegalArgumentException("totalCapacity can not be negative.");
		}
		
		this.totalCapacity = totalCapacity;
	}
	
	/**
	 * get currentSpeed
	 * @return the currentSpeed
	 */
	public double getCurrentSpeed() {
		return this.currentSpeed;
	}
	
	/**
	 * set currentSpeed
	 * @param currentSpeed the currentSpeed to set
	 */
	public void setCurrentSpeed(double currentSpeed) {
		if (currentSpeed < 0) {
			throw new IllegalArgumentException("currentSpeed can not be negative.");
		}
		this.currentSpeed = currentSpeed;
	}
	
	/**
	 * get max speed
	 * @return the maximumSpeed
	 */
	public double getMaximumSpeed() {
		return this.maximumSpeed;
	}
	
	/**
	 * set max speed
	 * @param maximumSpeed the maximumSpeed to set
	 */
	public void setMaximumSpeed(double maximumSpeed) {
		if (maximumSpeed < 0 || maximumSpeed > 150) {
			throw new IllegalArgumentException(this.getErrorCode("001"));
		}
		this.maximumSpeed = maximumSpeed;
	}
	
	/**
	 * get direction
	 * @return the direction
	 */
	public String getDirection() {
		return this.direction;
	}
	
	/**
	 * set direction
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		if (direction == null || direction.equals("") || direction.equals(" ")) {
			throw new IllegalArgumentException("direction can not be null, empty, or only whitespace.");
		}
		
		if (!direction.equals("North") && !direction.equals("South") && !direction.equals("East") && !direction.equals("West")) {
			throw new IllegalArgumentException(this.getErrorCode("002"));
		}
		this.direction = direction;
	}
	
	/**
	 * get engineHours
	 * @return the engineHours
	 */
	public double getEngineHours() {
		return this.engineHours;
	}
	
	/**
	 * set engineHours
	 * @param engineHours the engineHours to set
	 */
	public void setEngineHours(double engineHours) {
		if (engineHours < this.getEngineHours()) {
			throw new IllegalArgumentException(this.getErrorCode("003"));
		}
		if (engineHours < 0) {
			throw new IllegalArgumentException("engineHours can not be negative");
		}
		this.engineHours = engineHours;
	}
	
	/**
	 * implements accelerate from MotorizedVehicle
	 */
	@Override
	public void accelerate() {
		this.setCurrentSpeed(this.currentSpeed + 1);
	}
	
	/**
	 * implements decelerate from MotorizedVehicle
	 */
	@Override
	public void decelerate() {
		this.setCurrentSpeed(this.currentSpeed - 1);
	}
	
	/**
	 * implements turn from MotorizedVehicle
	 */
	@Override
	public void turn(String direction) {
		this.setDirection(direction);
	}
	
	/**
	 * implements serviceRequired from MotorizedVehicle
	 */
	@Override
	public boolean serviceRequired() {
		return false;
	}
	
	/**
	 * Accelerate boat, set engine hours to current engine hours +1
	 * @return string w/ current speed and current direction
	 */
	public String sail() {
		this.accelerate();
		this.setEngineHours(this.engineHours + 1);
		return "Boat's Current Speed: " + this.getCurrentSpeed() + ", Boat's Current Direction " + this.getDirection();
	}
	
	/**
	 * Error Codes thrown when conditions are not met
	 * @param errorKey
	 * @return errorKey to code
	 */
	public String getErrorCode(String errorKey) {
		HashMap<String, String> errorCodes = new HashMap<String, String>();
		
		errorCodes.put("001", "maximumSpeed can not be negative or greater than 150.");
		errorCodes.put("002", "direction must equal North, South, East, or West.");
		errorCodes.put("003", "engineHours can not be decremented");
		
		return errorCodes.get(errorKey);
	}
	
}
