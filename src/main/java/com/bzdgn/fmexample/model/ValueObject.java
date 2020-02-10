package com.bzdgn.fmexample.model;

public class ValueObject {
	
	private String name;
	private String developer;

	public ValueObject(String name, String developer) {
		this.name = name;
		this.developer = developer;
	}

	public String getName() {
		return name;
	}

	public String getDeveloper() {
		return developer;
	}

}
