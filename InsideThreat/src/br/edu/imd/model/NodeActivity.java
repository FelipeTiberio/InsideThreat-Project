package br.edu.imd.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa o node da árvore que possui a Activity como objeto.
 * @author Felipe / Matheus
 */
public class NodeActivity implements Node<Activity,Activity> {
	private  Activity data = null;
	private  NodePc parent  = null;
	private  List<NodeActivity> children = new LinkedList<NodeActivity>();

	/**
	 * Construtor parametrizado da classe.
	 * @param data a Activity que será o representante desse Node.
	 */
	public NodeActivity(Activity data) {
		this.data = data;
	}
	
 	/**
 	 * Método getter para o atributo data.
 	 * @return a Activity armazenada no Node.
 	 */
 	public Activity getData() {
 		return data;
 	}

 	/**
 	 * Método setter para o atributo data.
 	 * @param data objeto do tipo Devices que será armazenado no atributo data.
 	 */
 	public void setData(Devices data) {
 		this.data = data;
 	}
	
	/**
	 * Método getter para o atributo parent.
	 * @return NodePc com o valor do atributo parent.
	 */
	public NodePc getParent() {
		return parent;
	}
	
	/**
	 * Métodoo setter para o atributo parent.
	 * @param parent novo NodePC que será atribuído ao atributo parent.
	 */
	public void setParent(NodePc parent) {
		this.parent = parent;
	}

	/**
	 * Método getter para o atributo children.
	 * @return list com todos os filhos do Node.
	 */
 	public List<NodeActivity> getChildren() {
 		return children;
 	}
}
