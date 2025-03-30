package com.navin.CarTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyCar {
	@Autowired
	@Qualifier("ferrari")
	
	private SuperCar car;
	
	public void seeSpeed() {
		System.out.printf("My speed is %.2f \n", car.speed());
	}
	
	public void viewCapacity() {
		System.out.printf("My capacity is %d \n", car.capacity());
	}
}
