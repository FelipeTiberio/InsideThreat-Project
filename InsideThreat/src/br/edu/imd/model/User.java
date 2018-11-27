package br.edu.imd.model;

/**
 * Classe que representa o usuário e todos suas características
 * @author Felipe / Matheus
 *
 */
public class User implements Comparable<User>{
	private String employerName;
	private String userId;
	private String email;
	private String domain;
	private String role;
	private double distanceValue;
	
	/**
	 * Construtor padrão da classe
	 */
	public User(){}

	/**
	 * Construtor parametrizado da classe
	 * @param employer_name O nome do usuário
	 * @param user_id o id do usário
	 * @param email o email do usário
	 * @param domain o domínio do usuário
	 * @param role o papel d ousuário na empresa
	 */
	public User(String employer_name, String user_id, String email, String domain, String role) {
		super();
		this.employerName = employer_name;
		this.userId =  "DTAA/".concat(user_id)  ;
		this.email = email;
		this.domain = domain;
		this.role = role;
		this.distanceValue = 0;
	}

	/**
	 * Método getter para o atributo employerName
	 * @return String com o nome do usuário
	 */
	public String getEmployerName() {
		return employerName;
	}

	/**
	 * Método setter para o atributo employerName
	 * @param employer_name o novo nome que será atribuído
	 */
	public void setEmployerName(String employer_name) {
		this.employerName = employer_name;
	}

	/**
	 * Método getter para o atributo id
	 * @return o id do usuário
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Método setter para o atributo id
	 * @param user_id o nodo id que será atribuído
	 */
	public void setUserId(String user_id) {
		this.userId = user_id;
	}

	/**
	 * Método getter para o atributo email
	 * @return String com o email do uusário
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método setter para o atributo email
	 * @param email o novo email que será atrbuído
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método getter para o atributo domain
	 * @return String com o domínio do usuário
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Método setter para o atributo domain
	 * @param domain o novo domínio que será atrbuído
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	/**
	 * Método getter para o atributo role
	 * @return Sring com o papel do usuário
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Método setter para o atributo role
	 * @param role noov papel que será atribuído
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Método getter para o atributo distanceValue
	 * @return int com o valor da distância Euclidiana com o perfil médio
	 */
	public double getDistanceValue() {
		return distanceValue;
	}

	/**
	 * Método setter para o atributo distanceValue
	 * @param distance_value novo valor de distância Euclidiana que será atribuído
	 */
	public void setDistanceValue(double distance_value) {
		this.distanceValue = distance_value;
	}

	/**
	 * Método para impressão na tela do id do user quando o user for chamado
	 */
	@Override
	public String toString() {
		return "User [user_id=" + userId + "]";
	}

	/**
	 * Método utilizado para criar uma lógica de comparação entre os usários
	 */
	@Override
	public int compareTo(User user) {
		if(this.getDistanceValue() < user.getDistanceValue()) {
			return -1;			
		} else if(this.getDistanceValue() > user.getDistanceValue())
			return 1;	
		return 0;
	}

}
