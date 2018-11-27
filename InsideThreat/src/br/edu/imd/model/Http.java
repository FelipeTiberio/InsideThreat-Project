package br.edu.imd.model;

/**
 * Classe que herda de Activity e específica a atividade de http
 * @author Felipe / Matheus
 */
public class Http extends Activity{
	private String url;

	/**
	 * Construtor da classe 
	 * @param id o id da atividade
	 * @param date a data a qual foi realizada
	 * @param user o usuário a qual praticou
	 * @param pc o pc que foi utulizado
	 * @param url a utl que foi acessada
	 */
	public Http(String id, String date, String user, String pc, String url) {
		super(id, date, user, pc);
		this.url = url;
	}
	
	/**
	 * Método getter para o atributo url
	 * @return String com a url acessada
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Método setter para o atributo url
	 * @param url nova url que será atribuída
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Método para impressão na tela da url acessada
	 */
	@Override
	public String toString() {
		return "Http [url=" + url + "]";
	}
}
