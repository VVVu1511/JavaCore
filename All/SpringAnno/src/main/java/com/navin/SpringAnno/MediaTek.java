package com.navin.SpringAnno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component


public class MediaTek implements MobileProcessor {
	
	private double price;
	
	{
		price = 50.12;
	}
	
	
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("2nd best CPU");
		System.out.printf("Price: %.2f\n", this.price);
	}

}
