package br.edu.imd.model;

import java.util.Date;

/**
 * Classe que representa o tempo para escolha do usuário na amostragem dos dados
 * @author Felipe / Matheus
 */
public class Tempo {
	private int numDevices;
	boolean ifall;
	Date inicio = null;
	Date fim = null;

	/**
	 * Construtor padrão da classe
	 */
	public Tempo( ) {
		ifall = true;
		this.numDevices = 0;
	}

	/**
	 * Construtor parametrizado da classe
	 * @param inicio data de início da amostragem
	 * @param fim data final da amostragem
	 */
	public Tempo(Date inicio, Date fim) {
		this.inicio = inicio;
		this.fim = fim;
		this.numDevices = 0;
		this.ifall = false;
	}

	/**
	 * Métod para verificar se é todo o tempo
	 * @return o atributo ifall que é inicializado como verdadeiro 
	 */
	public boolean isIfall() {
		return ifall;
	}

	/**
	 * Método setter para o atributo ifall
	 * @param ifall novo valor a ser atribuído
	 */
	public void setIfall(boolean ifall) {
		this.ifall = ifall;
	}
	
	/**
	 * Método getter para o atributo numDevices
	 * @return o números de devices
	 */
	public int getNumDevices() {
		return numDevices;
	}
	
	/**
	 * Método setter para o atributo numDevices
	 * @param n_devices o novo valor de devices que será atribuído
	 */
	public void setNumDevices(int n_devices) {
		this.numDevices = n_devices;
	}
	
	/**
	 * Método getter para o atributo inicio
	 * @return data de início
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * Método setter para o atributo inicio
	 * @param inicio nova data de início que será atribuída
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	/**
	 * Método getter para oa atributo fim
	 * @return data fim
	 */
	public Date getFim() {
		return fim;
	}

	/**
	 * Método setter para o atributo fim
	 * @param fim nova data de fim que será atrbuída
	 */
	public void setFim(Date fim) {
		this.fim = fim;
	}

	/**
	 * Método para impressão na tela a informação é todo o tempo ou não
	 */
	@Override
	public String toString() {
		return "Tempo [ifall=" + ifall + "]";
	}
}
