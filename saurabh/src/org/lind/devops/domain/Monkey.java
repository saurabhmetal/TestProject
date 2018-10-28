package org.lind.devops.domain;

public class Monkey extends Animal{

	private String name ;
	private int foodUnit = 10 ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Monkey(String name) {
		super();
		this.name = name;
	}

	public int getFoodUnit() {
		return foodUnit;
	}
	
	
}
