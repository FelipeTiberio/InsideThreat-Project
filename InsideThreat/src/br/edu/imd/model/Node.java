package br.edu.imd.model;
import java.util.List;

/**
 * Interface que representa o Node.
 * @author Felipe / Matheus
 * @param <T> tipo do objeto do Node.
 * @param <F> tipo do objeto dos filhos do Node.
 */
public interface Node<T,F> {
	public T getData();
	public <G,H> List<Node<G,H>>  getChildren();
}
