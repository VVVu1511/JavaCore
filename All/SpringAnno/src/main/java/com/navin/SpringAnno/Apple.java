package com.navin.SpringAnno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component


public class Apple implements MobileProcessor {

	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("World 1st CPU!");
	}

}
