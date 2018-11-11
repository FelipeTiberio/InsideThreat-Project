import java.util.ArrayList;
import java.util.List;

/**@autor Felipe Tiberio
* Baseada em https://www.javagists.com/java-tree-data-structure **/

/**@TODO
* Ãˆ necessÃ¡rio criar um classe, usando uma matriz provavelmento,
* para o historograma de cada nÃ³.
 */

public class Node<T> {

	private T data = null;

	private List<Node<T>> children = new ArrayList<Node<T>>();

	private Node<T> parent = null;

	public Node(T data) {
		 this.data = data;
	}

	/**Adiciona um filho a um Åƒode, @return retorna o filho adicionado */
 
	public void addChild(Node<T> child) {
		child.setParent(this);
		this.children.add(child);
		
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

 	/**@return retorna o canteÃºdo armazenado em um nÃ³ */

 	public T getData() {
 		return data;
 	}

 	/**MÃ©todo usado guarda dados a um nÃ³ */
 
 	public void setData(T data) {
 		this.data = data;
 	}
 
	private void setParent(Node<T> parent) {
		this.parent = parent;
	}
	 
	public Node<T> getParent() {
		return parent;
	}

	/**@return Retorna a raiz a partir de qualquer nÃ³ **/

	public Node<T> getRoot() {
 		if(parent == null){
  			return this;
 		}
 			return parent.getRoot();
	}
	
	
	/**
	 * Método debug para imprimir a árvore @TODO lembrar de pagar 
	 * É NECESSÁRIO IMPLEMENTAR O MÉTODO TO STRING DE CADA NO QUE ESTÁ EM DATA
	 */
	public  void printTree(String separador) {
		_preintTree(this, separador);
	}
	
	/**
	 * Método debug para imprimir a árvore @TODO lembrar de pagar 
	 * @param separador
	 */
	
	public static <T> void _preintTree(Node<T> node, String appender) {
		System.out.println(appender + node.getData());
		   node.getChildren().forEach(each -> _preintTree(each, appender + appender));
	}
		
		
		
		
	}
 
