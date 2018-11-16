package br.edu.imd.controller;
import java.util.Date;

import br.edu.imd.model.*;

public class ProfileTree {
	private NodeUser raiz = null;
	
	/**
	 * @param user classe que armazerno  os dados dos usuários 
	 */
	ProfileTree(User user){
		raiz = new NodeUser(user);
		raiz.addChild(new NodeTempo(new Tempo()));
	}
	
	ProfileTree(User user, Date inicio, Date fim ){
		raiz = new NodeUser(user);
		raiz.addChild(new NodeTempo(new Tempo(inicio, fim)));
	}
	
	/**
	 * O método add mais um NodePc como filho de Tempo
	 * @param new_pc  Argumento será usando como parametro para um novo Nó do tipo pc
	 */
	private void addPc(Pc new_pc) {
		raiz.getChildren().get(0).addChild(new NodePc( new_pc));;
	}
	
	/**
	 * O Método recebe o nome de um pc, e verifica se esse Pc já existe na árvore
	 * @param nomePc String correspondente a o nume de um ṕc
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
	 * O método primeiro verifica se o pc, correspondente aquela atividade já existe,
	 * caso já exista, verifica se atividade já exites, caso não exita, adciona a nova atividade
	 * caso já exista retona false.
	 * @param activity
	 * @return
	 */
	
	
	public boolean addActivity(Activity activity) {
		NodePc pc = buscaPc(activity.getPc()); // Buscas se o pc correspondente a atividade já existe na árvore 
		
		if(pc != null) { // Caso o pc já exista, busca se atividade já exista, caso não exista então, então add nova atividade
			for(NodeActivity act : pc.getChildren()) {
				if(act.getData() == activity) {
					return false;
				}	
			}
			pc.addChild(new NodeActivity(activity));// Add novo nó com a atividade  no pc correspondente 
			return true;
			
			
		} // caso o pc não exista então primeiro irá criar um no para o pc, só depois add nova atividade
			NodePc newPc = new NodePc(new Pc(activity.getPc()));
			raiz.getChildren().get(0).addChild(newPc);
			newPc.addChild(new NodeActivity(activity));
			
		return true;
		
	}
	
	public NodeUser raiz() {
		return raiz;
	}
	
	public static <F,T>  void preintTree(Node<F,T> node, String appender) {
		System.out.println(appender + node.getData());
		   //node.getChildren().forEach(each -> preintTree(each, appender + appender));
		for(Node n : node.getChildren()) {
			preintTree(n, appender + appender);
		}
	}


}