package br.edu.imd.model;

import java.util.LinkedList;
import java.util.List;

public class NodeTempo implements Node<Tempo,Devices> {
	private  Tempo data = null;
	private  Node<User,Tempo> parent  = null;
	private  List<NodePc> children = new LinkedList<NodePc>();

	public NodeTempo(Tempo data) {
		 this.data = data;
	}

	public void setParent(NodeUser parent) {
		this.parent = parent;
	}

	/**Adiciona um filho a um Åƒode, @return retorna o filho adicionado */
	public void addChild(NodePc  child) {
		child.setParent(this);
		this.children.add(child);

	}

	//**Add filhos a um Node a partir de um List de Nodes **/
	public void addChildren(List<NodePc>children) {
	 	//children.forEach(each -> each.setParent(this));
	 	this.children.addAll(children);
 	}

 	/**@return retorna uma lista com todos os filhos de um node*/
 	public List<NodePc> getChildren() {
 		return children;
 	}

 	/**@return retorna o canteÃºdo armazenado em um nÃ³ */
 	public Tempo getData() {
 		return data;
 	}

 	/**MÃ©todo usado guarda dados a um nÃ³ */
 	public void setData(Tempo data) {
 		this.data = data;
 	}

	public Node<User,Tempo> getParent() {
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
