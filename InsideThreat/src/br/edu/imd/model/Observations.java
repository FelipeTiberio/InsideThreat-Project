package br.edu.imd.model;



public class Observations {
	private int n_devices;
	private String type;
	
	public Observations(String type ){
		this.type = type;
		this.n_devices = 0;
	}

	public int getN_devices() {
		return n_devices;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Observations [type=" + type + "]";
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setN_devices(int n_devices) {
		this.n_devices = n_devices;
	}
	
	
}
