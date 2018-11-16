package br.edu.imd.model;

public abstract class Activity  {
	private String id;
	private String date;
	private String user;
	private String pc;

	public Activity(String id, String date, String user, String pc) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.pc = pc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	@Override
	public String toString() {
		return "Activity [getId()=" + getId() + "]";
	}

	public boolean equals(Activity obj) {
  	if(this.id.equals(obj.getId() )) {
    	return true;
    }
			return false;
  }
}
