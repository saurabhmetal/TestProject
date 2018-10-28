package org.lind.devops.domain;

public class Lion extends Animal{

	private String name ;
	private int foodUnit = 10 ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lion(String name) {
		super();
		this.name = name;
	}
	
	public int getFoodUnit() {
		return foodUnit;
	}
	
	
}
