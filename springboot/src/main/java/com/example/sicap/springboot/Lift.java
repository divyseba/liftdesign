package com.example.sicap.springboot;

enum direction{
	UP,DOWN;
}

enum State {
	MOVING, STOPPED, IDLE
}

 interface Lift {
	 
	void enterDestination(int destination);

	void callLift(int destination, direction direction);
}
