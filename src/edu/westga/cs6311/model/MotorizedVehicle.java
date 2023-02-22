package edu.westga.cs6311.model;

/**
 * Interface for MotorizedVehicle
 * @author justinmaxwell
 * @version 2/22/23
 *
 */
public interface MotorizedVehicle {
	void accelerate();
	void decelerate();
	void turn(String direction);
	boolean serviceRequired();
}