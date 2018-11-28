package br.edu.imd.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NodeUser  implements Node<User,Tempo>{
	private User data = null;
	private Histograma histogram = new Histograma();
	private List<NodeTempo> children = new LinkedList<NodeTempo>();
	//private Node<T> parent = null;

	public NodeUser(User data) {
		 this.data = data;
	}

	/**Adiciona um filho a um Ã…Æ’ode, @return retorna o filho adicionado */
	public void addChild(NodeTempo child) {
		child.setParent(this);
		this.children.add(child);
	}

	//**Add filhos a um Node a partir de um List de Nodes **/
	public void addChildren(List<NodeTempo> children) {
	 	//children.forEach(each -> each.setParent(this));
	 	this.children.addAll(children);
 	}

 	/**@return retorna uma lista com todos os filhos de um node*/
 	public List<NodeTempo> getChildren() {
 		return children;
 	}

 	/**@return retorna o canteÃƒÂºdo armazenado em um nÃƒÂ³ */
 	public User getData() {
 		return data;
 	}

 	/**MÃƒÂ©todo usado guarda dados a um nÃƒÂ³ */
 	public void setData(User data) {
 		this.data = data;
 	}

	public Histograma getHistogram() {
		return histogram;
	}

	public void setHistogram(Histograma histogram) {
		this.histogram = histogram;
	}

	/**
	 * Recebe um valor para ser acresentado no array do histograma no param id
	 * @param valor
	 * @param id
	 */

	public void addToHistogra(int valor, int id) {
		this.histogram.add(valor, id);
	}

}
