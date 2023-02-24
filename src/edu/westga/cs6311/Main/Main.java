package edu.westga.cs6311.Main;

import edu.westga.cs6311.model.Boeing737;
import edu.westga.cs6311.model.Car;
import edu.westga.cs6311.model.ModelY;

public class Main {

	public static void main(String[] args) {
		ModelY modelY = new ModelY();
		Boeing737 plane = new Boeing737();
		
		plane.setTotalPassengerCapacity(200);
		plane.setPassengerCapacity(201);
				
		System.out.println(plane.fly());
	}

}
