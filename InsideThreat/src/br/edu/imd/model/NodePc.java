package br.edu.imd.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa o node da árvore que possui o Pc como objeto.
 * @author Felipe / Matheus
 */
public class NodePc implements Node<Pc,Activity>{
	private  Pc data = null;
	private  NodeTempo parent  = null;
	private  List<NodeActivity> children = new LinkedList<NodeActivity>();

	/**
	 * Construtor parametrizado da classe.
	 * @param data o Pc que será o representante desse Node.
	 */
	public NodePc(Pc data) {
		this.data = data;
	}

	/**
	 * Método que adiciona um filho ao Node.
	 * @param child NodeAcitivty que será adicionado aos filhos do Node.
	 */
	public void addChild(NodeActivity  child) {
		child.setParent(this);
		this.children.add(child);

	}
	
	/**
	 * Método que adicona uma list aos filhos do Node.
	 * @param children list de NodeAcitivty que será adiciona aos filhos do Node.
	 */
	public void addChildren(List<NodeActivity>children) {
	 	this.children.addAll(children);
 	}
	
 	/**
 	 * Método getter para o atributo data.
 	 * @return objeto de Pc que é armazenado no Node.
 	 */
 	public Pc getData() {
 		return data;
 	}

 	/**
 	 * Método setter para o atributo data.
 	 * @param data novo Tempo que será armazenado no atributo data.
 	 */
 	public void setData(Pc data) {
 		this.data = data;
 	}
 	
 	/**
 	 * Método getter para o atributo parent.
 	 * @return NodeTempo com o valor do atributo parent.
 	 */
	public NodeTempo getParent() {
		return parent;
	}
	
	/**
	 * Método setter para o atributo parent.
	 * @param parent novo NodeTempo que será adicionado ao atributo parent.
	 */
	public void setParent(NodeTempo parent) {
		this.parent = parent;
	}

	/**
	 * Método getter para o atributo children.
	 * @return list com todos os filhos do Node.
	 */
 	public List<NodeActivity> getChildren() {
 		return children;
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
