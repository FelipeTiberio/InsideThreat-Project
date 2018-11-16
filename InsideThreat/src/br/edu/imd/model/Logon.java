package br.edu.imd.model;

public class Logon extends Activity {
	private String activity;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Logon(String id, String date, String user, String pc, String activity) {
		super(id, date, user, pc);
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Logon [activity=" + activity + "]";
	}
}
