package com.navin.SpringAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Samsung s7 = factory.getBean(Samsung.class);
    	Apple a7 = factory.getBean(Apple.class);
    	
        s7.config();
        a7.process();
    }
}
