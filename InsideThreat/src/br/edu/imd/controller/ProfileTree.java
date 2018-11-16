package br.edu.imd.controller;
import java.util.Date;

import br.edu.imd.model.*;

public class ProfileTree {
	private NodeUser raiz = null;
	
	/**
	 * @param user classe que armazerno  os dados dos usuários 
	 */
	ProfileTree(User user){
		raiz = new NodeUser(user);
		raiz.addChild(new NodeTempo(new Tempo()));
	}
	
	ProfileTree(User user, Date inicio, Date fim ){
		raiz = new NodeUser(user);
		raiz.addChild(new NodeTempo(new Tempo(inicio, fim)));
	}
	
	/**
	 * Método usado para add novos devices na árvore n aárvore do usuário.
	 * @param new_dev novo 
	 * @return O método verifica primeiro se o new_dev já está na árvore, se sim retorna Treu,
	 *  se não retorna False e add new_dev na árvore
	 */
	
	public boolean addDevicies(Devices new_dev) {
		for(NodeTempo tempo : raiz.getChildren()) {
			for(NodeDevices dev: tempo.getChildren()) {
				if(dev.getData() == new_dev) {
					return true;
				}
			}
		}
		
		raiz.getChildren().get(0).addChild(new NodeDevices(new_dev));
		
		return false;
	}


}
