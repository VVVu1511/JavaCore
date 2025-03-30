package com.navin.CarTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {
	  
	  ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
	  
//	  Ferrari testFerrari = (Ferrari)factory.getBean(Ferrari.class);
//	  System.out.println(testFerrari.speed());
	  
	  MyCar testCar = (MyCar)factory.getBean("myCar");
	  testCar.seeSpeed();
	  testCar.viewCapacity();
  }
}
