package br.edu.imd.model;



public class User {
	private String employer_name;
	private String user_id;
	private String email;
	private String domain;
	private String role;
	
	
	public User() {
		
	}
	
	
	public User(String employer_name, String user_id, String email, String domain, String role) {
		super();
		this.employer_name = employer_name;
		this.user_id = user_id;
		this.email = email;
		this.domain = domain;
		this.role = role;
	}
	
	public String getEmployer_name() {
		return employer_name;
	}
	public void setEmployer_name(String employer_name) {
		this.employer_name = employer_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + "]";
	}

	
}
