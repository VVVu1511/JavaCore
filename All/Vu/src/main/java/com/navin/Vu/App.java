package com.navin.Vu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
  public static void main(String[] args) {
    
	 ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	  
//	 Vehicle obj = (Vehicle)context.getBean("bike");
//    
//	 obj.drive();
	 
	 Car t = (Car)context.getBean("car");
	 
	 t.drive();
	 
  }
}
