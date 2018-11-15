package br.edu.imd.model;

import java.util.List;

public interface Node<T,F> {
	
	public T getData();
	public <G,H> List<Node<G,H>>  getChildren();
	//public void forEach(Object object);
 

}
