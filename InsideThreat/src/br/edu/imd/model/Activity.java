package br.edu.imd.model;

/**
 * Classe abstrata que representa as atividades
 * @author Felipe / Matheus
 */
public abstract class Activity  {
	private String id;
	private String date;
	private String user;
	private String pc;

	/**
	 * Construtor da classe
	 * @param id o id da atividade
	 * @param date a data a qual foi realizada
	 * @param user o usuário a qual praticou
	 * @param pc o pc que foi utulizado
	 */
	public Activity(String id, String date, String user, String pc) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.pc = pc;
	}
	
	/**
	 * Método getter do atributo id
	 * @return String com o id da atvidade
	 */
	public String getId() {
		return id;
	}

	/**
	 * Métod setter do atributo id
	 * @param id o id que será atribuido a atividade
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Método getter do atributo date
	 * @return Date com a data da atividade
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Método setter do atributo date
	 * @param date que será atribuída a atividade
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Método getter do atributo user
	 * @return String com o id do user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Método setter do atributo user
	 * @param user id do nono usuário que a atividade será atribuída
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Método getter para o atributo pc
	 * @return String com o id do pc que foi utilizado
	 */
	public String getPc() {
		return pc;
	}

	/**
	 * Método setter para o atributo pc
	 * @param pc String com o id do novo pc para a atividade
	 */
	public void setPc(String pc) {
		this.pc = pc;
	}

	/**
	 * Método para impressão na tela do id quando a atividade for chamada para impressão
	 */
	@Override
	public String toString() {
		return "Activity [getId()=" + getId() + "]";
	}

	/**
	 * Método para verificação de igualdade entre objetos
	 * @param obj objeto do tipo Activity que será comparado
	 * @return true se forem iguais, falso, caso contrário
	 */
	public boolean equals(Activity obj) {
		if(this.id.equals(obj.getId())) {
			return true;
		}	
		return false;
	}
}
