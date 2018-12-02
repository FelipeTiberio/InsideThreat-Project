package br.edu.imd.model;

/**
 * Classe que herda de Activity e específica a atividade de devices
 * @author Felipe / Matheus
 */
public class Devices  extends Activity{
	private String activity;

	/**
	 * Construtor da classe 
	 * @param id o id da atividade
	 * @param date a data a qual foi realizada
	 * @param user o usuário a qual praticou
	 * @param pc o pc que foi utulizado
	 * @param activity atividade realizada no ato de device
	 */
	public Devices(String id, String date, String user, String pc, String activity) {
		super(id, date, user, pc);
		this.activity = activity;
	}

	/**
	 * Método getter para o atributo activity
	 * @return String a nova atividade realizada
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * Método setter para o atributo activity
	 * @param activity nova atividade realizada que será atribuída
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * Método para impressão na tela da atividade específica realizada 
	 */
    @Override
    public String toString() {
        return "[Devices =" + this.getId() + "]";
    }
    
    /**
     * Método retorna todos os dados de device em um array de strings
     */

	@Override
	public String[] status() {
		String campos[] = new String[5];
		campos[0] = this.getId();
		campos[1] = this.getDate();
		campos[2] = this.getUser();
		campos[3] = this.getPc();
		campos[4] = this.getActivity();
		return campos;
	}
         
}
