package com.navin.SpringAnno;

public class Samsung {
	
	
	MobileProcessor cpu;
	
	public MobileProcessor getCpu() {
		return cpu;
	}

	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}

	public void config() {
		System.out.println("Octa Core, 4 gb Ram, 12MP camera");
		cpu.process();
	}
}
