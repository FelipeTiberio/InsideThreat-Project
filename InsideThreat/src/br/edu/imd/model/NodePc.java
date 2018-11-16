package br.edu.imd.model;

import java.util.ArrayList;
import java.util.List;

public class NodePc implements Node<Pc,Activity>{
	private  Pc data = null;
	private  NodeTempo parent  = null;
	private  List<NodeActivity> children = new ArrayList<NodeActivity>();
	
	public NodePc(Pc data) {
		this.data = data;	
	}
	
	public void setParent(NodeTempo parent) {
		this.parent = parent;
	}

	/**Adiciona um filho a um Åƒode, @return retorna o filho adicionado */
	public void addChild(NodeActivity  child) {
		child.setParent(this);
		this.children.add(child);
		
	}
	//**Add filhos a um Node a partir de um List de Nodes **/
	
	public void addChildren(List<NodeActivity>children) {
	 	children.forEach(each -> each.setParent(this));
	 	this.children.addAll(children);
 	}

 	/**@return retorna uma lista com todos os filhos de um node*/

 	public List<NodeActivity> getChildren() {
 		return children;
 	}

 	/**@return retorna o canteÃºdo armazenado em um nÃ³ */

 	public Pc getData() {
 		return data;
 	}

 	/**MÃ©todo usado guarda dados a um nÃ³ */
 
 	public void setData(Pc data) {
 		this.data = data;
 	}
 
	 
	public NodeTempo getParent() {
		return parent;
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
	public static <T> void _preintTree(NodeTempo node, String appender) {
		System.out.println(appender + node.getData());
		   node.getChildren().forEach(each -> _preintTree(each, appender + appender));
	}*/

}
