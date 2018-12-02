package br.edu.imd.model;

/**
 * Classe que representa o histograma
 * @author Felipe / Matheus
 */
public class Histograma {
	private int histogram[];
	private int qtdUsers;
	private boolean isAtt;
	
	/**
	 * Construtor padrão da classe. Preenche todas posições do array com 0
	 */
	public Histograma() {
		this.histogram = new int[24];
		qtdUsers = 1;
		isAtt = false;
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
	
	/**
	 * Método getter para o atributo qtdUsers
	 * @return int com quantidade de usuários com o mesmo papel do NodeUser desse histograma
	 */
	public int getQtdUsers() {
		return qtdUsers;
	}

	/**
	 * Método de adicionar um user a mais na qtdUsers
	 */
	public void addQtdUsers() {
		this.qtdUsers++;
	}
	
	/**
	 * Método de atualizar os valores do histograma, após todas as inclusões, os valores
	 * são dividos pela quantidade de usuários de mesmo papel a qual o histograma representa,
	 * para assim os valores de cada hora serem a média de todas as atvidades dos uuários
	 */
	public void attValues() {
		for(int i = 0; i < 24; i++) {
			histogram[i] = histogram[i]/qtdUsers;
		}
		isAtt = true;
	}

	/**
	 * Método para saber se o histograma já teve seu dados atualizados
	 * @return o valor lógico isAtt
	 */
	public boolean isAtt() {
		return isAtt;
	}

	/**
	 * Método setter para o atributo isAtt
	 * @param isAtt novo valor lógico que será atribuído
	 */
	public void setAtt(boolean isAtt) {
		this.isAtt = isAtt;
	}
}
