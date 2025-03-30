package com.navin.CarTime;

import org.springframework.stereotype.Component;

@Component
public class Bugatti implements SuperCar {

	@Override
	public double speed() {
		return 1000.05;
	}
	
	@Override
	public int capacity() {
		return 3;
	}
}
