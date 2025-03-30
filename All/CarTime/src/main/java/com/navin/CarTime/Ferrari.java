package com.navin.CarTime;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Ferrari implements SuperCar {

	@Override
	public double speed() {
		return 300.60;
	}
	
	@Override
	public int capacity() {
		return 4;
	}
}
