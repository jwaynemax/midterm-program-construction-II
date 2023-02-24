package edu.westga.cs6311.Main;

import edu.westga.cs6311.model.Boeing737;
import edu.westga.cs6311.model.Car;
import edu.westga.cs6311.model.ModelY;
import edu.westga.cs6311.model.R35;

public class Main {

	public static void main(String[] args) {
		ModelY modelY = new ModelY();
		Boeing737 plane = new Boeing737();
		R35 boat = new R35();
		
		plane.setEngineHours(5000);
		
		System.out.println(plane.fly());
	}

}
