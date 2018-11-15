package br.edu.imd.model;



public class Http extends Activity{
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Http(String id, String date, String user, String pc, String url) {
		super(id, date, user, pc);
		this.url = url;
		// TODO Auto-generated constructor stub
	}

}
