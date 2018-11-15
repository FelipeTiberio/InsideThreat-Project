package br.edu.imd.model;

import java.util.Date;

public class Tempo {
	private int n_devices;
	boolean ifall;
	Date inicio = null;
	Date fim = null;
	
	public Tempo( ){
		ifall = true;
		this.n_devices = 0;
	}
	
	public Tempo(Date inicio, Date fim) {
		this.inicio = inicio;
		this.fim = fim;
		this.n_devices = 0;
		this.ifall = false;
		
	}

	public int getN_devices() {
		return n_devices;
	}
	
	
	@Override
	public String toString() {
		return "Tempo [ifall=" + ifall + "]";
	}

	public boolean isIfall() {
		return ifall;
	}

	public void setIfall(boolean ifall) {
		this.ifall = ifall;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public void setN_devices(int n_devices) {
		this.n_devices = n_devices;
	}
	
	
}
