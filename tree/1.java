import java.util.ArrayList;
import java.util.List;

/**@TODO  Talvez, também preciso coloar em cada nó um atributo que 
será o meu historograma */

public class Node<T> {
	private List<Node<T>>  children = new ArrayList<Node<T>>();
	private Node<T> parent = null;
	private T data = null;


	public Node( T data){
		this.data = data;
	}

	public Node(T data, Node<T> parent){
		this.data = data;
		this.setParent(parent);
	}

	/** 
	*@return retorna um lista contendo todos os filhos diretos de um Node,
	*retorna null, caso o Node não possua um filho.
	*/

	public List<Node<T>> getChildren(){
		return children;
	}

	/**
	* Método usando para alterar o pai de um nó
	*/

	public void setParent(Node <T> parent){
		parent.addChild(this);
		this.parent = parent;
	}

	  public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }

}