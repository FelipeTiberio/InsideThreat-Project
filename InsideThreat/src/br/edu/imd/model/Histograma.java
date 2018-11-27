package br.edu.imd.model;

/**
 * Classe que representa o histograma
 * @author Felipe / Matheus
 */
public class Histograma {
	int histogram[];
	
	/**
	 * Construtor padrão da classe. Preenche todas posições do array com 0
	 */
	public Histograma() {
		this.histogram = new int[24];
		
		for(int i =0; i<24; i++) {
			histogram[i] = 0;
		}
	}
	
	/**
	 * Método getter para o atributo histogram
	 * @return Array com todos os seus valores
	 */
	public int[] getHistograma() {
		return histogram;
	}

	/**
	 * Método para adicionar um novo valor no histograma
	 * @param valor int que representa a quantidade de atividades
	 * @param id int que representa a hora
	 */
	public void add(int valor, int id) {
		histogram[id] += valor;
	}
	
	/**
	 * Método para buscar a quantidade de atividades em uma hora específica
	 * @param index a hora que deseja a quantidade de atividades
	 * @return a quantidade de atividades no índice desejado
	 */
	public int getValue(int index) {
		return histogram[index];
	}

}
