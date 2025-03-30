package com.navin.CarTime;

import org.springframework.stereotype.Component;

@Component
public class Lamboghini implements SuperCar {

	@Override
	public double speed() {
		return 200.50;
	}

	@Override
	public int capacity() {
		return 5;
	}

	
}
