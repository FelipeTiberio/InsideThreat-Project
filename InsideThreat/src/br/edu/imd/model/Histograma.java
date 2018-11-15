package br.edu.imd.model;

public class Histograma {
	int histograma[] ;

	public Histograma() {
		this.histograma = new int[24];
		
		for(int i =0; i<24; i++) {
			histograma[i] = 0;
		}
	}

	public int[] getHistograma() {
		return histograma;
	}

	public void setHistograma(int[] histograma) {
		this.histograma = histograma;
	}
	
	

}
