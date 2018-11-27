package br.edu.imd.model;

public class Devices  extends Activity{
	private String activity;

	public Devices(String id, String date, String user, String pc, String activity) {
		super(id, date, user, pc);
		this.activity = activity;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

    @Override
    public String toString() {
        return "Devices [activity=" + activity + "]";
    }
        
        
}
