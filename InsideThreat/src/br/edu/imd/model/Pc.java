package br.edu.imd.model;

/**
 * Classe que representa o pc
 * @author Felipe / Matheus
 */
public class Pc {
	private String name;

	/**
	 * Construtor parametrizado da classe
	 * @param name o nome do pc
	 */
	public Pc(String name) {
		super();
		this.name = name;
	}

	/**
	 * Método getter para o atributo name
	 * @return String com o nome do pc
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método setter para o atributo name
	 * @param name novo nome que será atrbuído
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método para impressão na tela o nome do pc quando o mesmo for chamado
	 */
	@Override
	public String toString() {
		return "Pc [name=" + name + "]";
	}
}
