package br.edu.imd.model;

import java.util.ArrayList;
import java.util.List;

public class NodeUser  implements Node<User,Tempo>{
	private User data = null;
	private List<NodeTempo> children = new ArrayList<NodeTempo>();
	//private Node<T> parent = null;

	public NodeUser(User data) {
		 this.data = data;
	}

	/**Adiciona um filho a um Åƒode, @return retorna o filho adicionado */
	public void addChild(NodeTempo child) {
		child.setParent(this);
		this.children.add(child);
	}

	//**Add filhos a um Node a partir de um List de Nodes **/
	public void addChildren(List<NodeTempo> children) {
	 	children.forEach(each -> each.setParent(this));
	 	this.children.addAll(children);
 	}

 	/**@return retorna uma lista com todos os filhos de um node*/
 	public List<NodeTempo>  getChildren() {
 		return children;
 	}

 	/**@return retorna o canteÃºdo armazenado em um nÃ³ */
 	public User getData() {
 		return data;
 	}

 	/**MÃ©todo usado guarda dados a um nÃ³ */
 	public void setData(User data) {
 		this.data = data;
 	}


	/**
	 * Método debug para imprimir a árvore @TODO lembrar de pagar
	 * É NECESSÁRIO IMPLEMENTAR O MÉTODO TO STRING DE CADA NO QUE ESTÁ EM DATA
	 */

 	/*
	public  void printTree(String separador) {
		_preintTree(this, separador);
	}*/

	/**
	 * Método debug para imprimir a árvore @TODO lembrar de pagar
	 * @param separador
	 */
	/*
	private static  void _preintTree(NodeUSer node, String appender) {
		System.out.println(appender + node.getData());
		   node.getChildren().forEach(each -> _preintTree(each, appender + appender));
	}*/



}
