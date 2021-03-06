package br.edu.imd.controller;

import java.util.Date;
import br.edu.imd.model.*;

/**
 * Classe responsável por manter a estrutura de uma árvore.
 * @author Felipe / Matheus
 */
public class ProfileTree {
	private NodeUser raiz = null;
	
	/**
	 * Construtor parametrizado da classe.
	 * @param user o usuário que será a raiz da árovre. 
	 */
	ProfileTree(User user){
		raiz = new NodeUser(user);
		raiz.addChild(new NodeTempo(new Tempo()));
	}
	
	/**
	 * Construtor parametrizado para um périodo específico da árvore
	 * @param user o usuário que será a raiz da árvore.
	 * @param inicio data do início.
	 * @param fim data final.
	 */
	ProfileTree(User user, Date inicio, Date fim ){
		raiz = new NodeUser(user);
		raiz.addChild(new NodeTempo(new Tempo(inicio, fim)));
	}
	
	/**
	 * O método adiciona mais um NodePc como filho de Tempo.
	 * @param newPc Argumento será usado como paramêtro para um novo NodePc.
	 */
	@SuppressWarnings("unused")
	private void addPc(Pc newPc) {
		raiz.getChildren().get(0).addChild(new NodePc(newPc));;
	}
	
	/**
	 * O Método recebe o nome de um pc, e verifica se esse Pc já existe na árvore
	 * @param nomePc String correspondente ao nome de um pc
	 * @return retorna true se o pc já estiver na árvore, false caso contrário 
	 */
	public NodePc buscaPc(String nomePc) {
		for(NodeTempo tempo : raiz.getChildren()) {
			for(NodePc pc : tempo.getChildren()) {
				if(pc.getData().getName().equals(nomePc)) {
					return pc;
				}
			}
		}
		return null;
	}
	
	/**
	 * Método usado para add de novas atividades na árvore de usuário.
	 * @param activity atividade que será acrescentada.
	 * @return O método primeiro verifica se o pc, correspondente aquela atividade já existe,
	 * caso já exista, verifica se atividade já exite, caso não exita, adciona a nova atividade
	 * caso já exista retona false.
	 */
	public boolean addActivity(Activity activity) {
		// Buscas se o pc correspondente a atividade já existe na árvore 
		NodePc pc = buscaPc(activity.getPc()); 
		String data[] = new String[2];
		String hora[] = new String[3];
		data = activity.getDate().split(" ");
		int horaInt;
		
		// Caso o pc já exista, busca se atividade já exista, caso não exista então, então add nova atividade
		if(pc != null) { 
			for(NodeActivity act : pc.getChildren()) {
				if(act.getData() == activity) {
					return false;
				}	
			}
			pc.addChild(new NodeActivity(activity));// Add novo nó com a atividade  no pc correspondente 
			
			// Código abaixo adcionar 1 no contador de atividades do histograma user
			hora = data[1].split(":");
			horaInt = Integer.parseInt(hora[0]);
			this.raiz.addToHistogra(1, horaInt);
			
			return true;
			
		} 	// caso o pc não exista então primeiro irá criar um no para o pc, só depois add nova atividade
			NodePc newPc = new NodePc(new Pc(activity.getPc()));
			raiz.getChildren().get(0).addChild(newPc);
			newPc.addChild(new NodeActivity(activity));
			hora = data[1].split(":");
			
			// Código abaixo adcionar 1 no contador de atividades do histograma user
			horaInt = Integer.parseInt(hora[0]);
			this.raiz.addToHistogra(1, horaInt);
			
		return true;
	}
	
	/**
	 * Método retorna o Nodeuser, a raiz da árvore.
	 * @return o objeto Nodeuser que a ProfileTree é correspondente.
	 */
	public NodeUser raiz() {
		return raiz;
	}
	
	/**
	 * Método utilizado para imprimir na tela a árvore.
	 * @param node Node a qual deseja imprimir.
	 * @param appender string que é utilizada para separar informações.
	 */
	@SuppressWarnings("unchecked")
	public static <F,T>  void preintTree(Node<F,T> node, String appender) {
		System.out.println(appender + node.getData());
		   //node.getChildren().forEach(each -> preintTree(each, appender + appender));
		for(@SuppressWarnings("rawtypes") Node n : node.getChildren()) {
			preintTree(n, appender + appender);
		}
	}
       
}
