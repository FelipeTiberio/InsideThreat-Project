import java.util.ArrayList;
import java.util.List;

/**@autor Felipe Tiberio
* Baseada em https://www.javagists.com/java-tree-data-structure **/

/**@TODO
* È necessário criar um classe, usando uma matriz provavelmento,
* para o historograma de cada nó.
 */

public class Node<T> {

	private T data = null;

	private List<Node<T>> children = new ArrayList<Node<T>>();

	private Node<T> parent = null;

	public Node(T data) {
		 this.data = data;
	}

	/**Adiciona um filho a um Ńode, @return retorna o filho adicionado */
 
	public Node<T> addChild(Node<T> child) {
		child.setParent(this);
		this.children.add(child);
		return child;
	}

	//**Add filhos a um Node a partir de um List de Nodes **/

	public void addChildren(List<Node<T>> children) {
	 	children.forEach(each -> each.setParent(this));
	 	this.children.addAll(children);
 	}

 	/**@return retorna uma lista com todos os filhos de um node*/

 	public List<Node<T>> getChildren() {
 		return children;
 	}

 	/**@return retorna o canteúdo armazenado em um nó */

 	public T getData() {
 		return data;
 	}

 	/**Método usado guarda dados a um nó */
 
 	public void setData(T data) {
 		this.data = data;
 	}
 
	private void setParent(Node<T> parent) {
		this.parent = parent;
	}
	 
	public Node<T> getParent() {
		return parent;
	}

	/**@return Retorna a raiz a partir de qualquer nó **/

	public Node getRoot() {
 		if(parent == null){
  			return this;
 		}
 			return parent.getRoot();
	}
 
}

