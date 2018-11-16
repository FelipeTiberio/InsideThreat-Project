package br.edu.imd.model;

public class Pc {
	private String name;
	
	public Pc(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pc [name=" + name + "]";
	}
	
	
	
	
}
