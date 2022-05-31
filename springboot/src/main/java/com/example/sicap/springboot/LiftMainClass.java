package com.example.sicap.springboot;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * LiftMainClass implements the functionality of lift operations.
 * 
 * @author Divya Razmi
 *
 */
public class LiftMainClass implements Lift{

	@Autowired
	LiftOEM liftOEM;

	private static int currentLiftPosition = 0;

	public static void main(String[] args) {
		LiftMainClass elevator = new LiftMainClass();
		elevator.callLift(3, direction.UP);
		elevator.enterDestination(2);
		elevator.callLift(5, direction.UP);
	}

	/**
	 * callLift method implements the functionality of user entering lift from outside the lift
	 *
	 * @param destination
	 * @param direction
	 */
	@Override
	public void callLift(int destination, direction direction) {
		int i= currentLiftPosition;
		if(Objects.nonNull(destination)) {
			while(destination != currentLiftPosition) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("We have reached floor -- " + i + "lift moving in  " + direction  + " direction");
				currentLiftPosition = i;
				if(currentLiftPosition < destination )
					i++;
				else
					i--;
			}
			System.out.println("Destination Reached..");
			//liftOEM.stop();
			//liftOEM.openDoor();
			//liftOEM.closeDoor();
		}
	}

	/**
	 * enterDestination method implements the functionality of lift movement with desired location
	 *
	 * @param destination
	 */
	@Override
	public void enterDestination(int destination) {
		if(Objects.nonNull(destination)) {
			//check for conditions (no. of persons exceeds / overload , power off , lift failure - emergency alert)
			//reach destination
			if(currentLiftPosition < destination) {
				callLift(destination, direction.UP);
				//liftOEM.moveUp();
			}else if(currentLiftPosition > destination) {
				callLift(destination, direction.DOWN);
				//liftOEM.moveDown();
			}
		}
	}


	public void floorReached(int floor) {
	}
}