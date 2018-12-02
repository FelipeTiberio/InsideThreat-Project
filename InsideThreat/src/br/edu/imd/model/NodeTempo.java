package br.edu.imd.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa o node da árvore que possui o Tempo como objeto.
 * @author Felipe / Matheus
 */
public class NodeTempo implements Node<Tempo,Devices> {
	private  Tempo data = null;
	private  Node<User,Tempo> parent  = null;
	private  List<NodePc> children = new LinkedList<NodePc>();

	/**
	 * Construtor parametrizado da classe.
	 * @param data o Tempo que será o representante desse Node.
	 */
	public NodeTempo(Tempo data) {
		 this.data = data;
	}

	/**
	 * Método que adiciona um filho ao Node.
	 * @param child NodePc que será adicionado aos filhos do Node.
	 */
	public void addChild(NodePc  child) {
		child.setParent(this);
		this.children.add(child);

	}

	/**
	 * Método que adicona uma list aos filhos do Node.
	 * @param children list de NodePc que será adiciona aos filhos do Node.
	 */
	public void addChildren(List<NodePc>children) {
	 	this.children.addAll(children);
 	}

 	/**
 	 * Método getter para o atributo data.
 	 * @return objeto de Tempo que é armazenado no Node.
 	 */
 	public Tempo getData() {
 		return data;
 	}

 	/**
 	 * Método setter para o atributo data.
 	 * @param data novo Tempo que será armazenado no atributo data.
 	 */
 	public void setData(Tempo data) {
 		this.data = data;
 	}
 	
 	/**
 	 * Método getter para o atributo parent.
 	 * @return Node<User,Tempo> com o valor do atributo parent.
 	 */
	public Node<User,Tempo> getParent() {
		return parent;
	}
	
 	/**
	 * Método setter para o atributo parent.
	 * @param parent novo NodeUser que será adicionado ao atributo parent.
	 */
	public void setParent(NodeUser parent) {
		this.parent = parent;
	}
 	
	/**
	 * Método getter para o atributo children.
	 * @return list com todos os filhos do Node.
	 */
 	@SuppressWarnings("unchecked")
	public List<NodePc> getChildren() {
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
