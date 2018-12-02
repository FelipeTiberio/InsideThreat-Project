package br.edu.imd.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa o node da árvore que possui o User como objeto.
 * @author Felipe / Matheus
 */
public class NodeUser  implements Node<User,Tempo>{
	private User data = null;
	private Histograma histogram = new Histograma();
	private List<NodeTempo> children = new LinkedList<NodeTempo>();
	//private Node<T> parent = null;

	/**
	 * Construtor parametrizado da classe.
	 * @param data o usuário que será o representante desse Node.
	 */
	public NodeUser(User data) {
		 this.data = data;
	}

	/**
	 * Método que adiciona um filho ao NodeUser.
	 * @param child o filho adicionado.
	 */
	public void addChild(NodeTempo child) {
		child.setParent(this);
		this.children.add(child);
	}

	/**
	 * Método que adiciona filhos ao Node a partir de um List de Nodes.
	 * @param children a list de nodes que será adicionados.
	 */
	public void addChildren(List<NodeTempo> children) {
	 	this.children.addAll(children);
 	}

	/**
	 * Recebe um valor para ser acresentado no array do histograma no índice id.
	 * @param valor o valor que será acrescentado.
	 * @param id o índice ao qual deve ser adicionado no array.
	 */
	public void addToHistogra(int valor, int id) {
		this.histogram.add(valor, id);
	}
	
	/**
	 * Método que acrescenta usuário na quantidade users de mesmo papel ao histograma
	 */
	public void addUserHistogram() {
		this.histogram.addQtdUsers();
	}
	
	/**
	 * Método que faz a atualização dos valores do histograma ao qual representa
	 */
	public void attValuesAvernageProfile() {
		this.histogram.attValues();
	}

 	/**
 	 * Método getter para o atributo data.
 	 * @return o user amazenado no Node;
 	 */
 	public User getData() {
 		return data;
 	}

 	/**
 	 * Método setter para o atributo data.
 	 * @param data novo user que será adicionado ao atributo data.
 	 */
 	public void setData(User data) {
 		this.data = data;
 	}

 	/**
 	 * Método getter para o histogram.
 	 * @return o histograma do Node.
 	 */
	public Histograma getHistogram() {
		return histogram;
	}

	/**
	 * Méttodo setter para o atributo histogram.
	 * @param histogram o novo histograma que será adiconado ao atributo histogram.
	 */
	public void setHistogram(Histograma histogram) {
		this.histogram = histogram;
	}
	
	/**
	 * Método getter para o atributo children.
	 * @return list com todos os filhos do Nod.e
	 */
 	@SuppressWarnings("unchecked")
	public List<NodeTempo> getChildren() {
 		return children;
 	}

}
