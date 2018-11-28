package br.edu.imd.controller;

import java.util.ArrayList;
import java.util.Collections;

import br.edu.imd.model.Histograma;
import br.edu.imd.model.NodeUser;
import br.edu.imd.model.User;

/**
 * Classe AnomalyAnalysis será responsável por verificar a existência de anomalias e garantir que tudo exista 
 * para poder ocorrer essa verificação.
 * @author Matheus
 *
 */
public class AnomalyAnalysis {
	KeepTrees keep;
	
	/**
	 * Construtor da classe AnomalyAnalysis, atribuindo o objeto keep.
	 * @param keep objeto da classe keep que será utilizado para acessar os dados.
	 */
	AnomalyAnalysis(KeepTrees keep){
		this.keep = keep;
	}
	
	/**
	 * Método responsável por verficar se o valor de distância do histograma do usuário é recebido é maior
	 * que a média dos valores de todos os usuário de mesmo pale que o seu.
	 * @param user usário a ser verificado.
	 * @return boolean que caso o usuário esteja com um valor de distância maior será verdadeiro, ao contrário
	 * será falso.
	 */
	public boolean analyzeUser(User user) {
		
		if(keep.existUser(user) && keep.searchAverangeProfile(user)) {	
			
			int contAux = 0;
			double valueAux = 0;
			String roleAux = user.getRole();
			
			for(ProfileTree nodeUser : keep.getUsers()) {
				if(nodeUser.raiz().getData().getRole().equals(roleAux)) {
					contAux++;
					valueAux += nodeUser.raiz().getData().getDistanceValue();
				}
			}
			
			valueAux = valueAux/contAux;
			
			if(user.getDistanceValue() <= valueAux && user.getDistanceValue() > 0) 
				return false;
			
		} 	else {
				System.out.println("Usário não existe ou não existe histograma de perfil médio do seu"
					+ "papel definido.");
		}
		
		return true;		
	}
	
	/**
	 * Método que chama o método para atribuir o valor de distância para todos os usuários.
	 */
	public void enterDistanceValue() {
		for(ProfileTree nodeUser : keep.getUsers()) {
			createDistanceValue(nodeUser.raiz().getData());
		}
	}

	/**
	 * Método que calcula e atribui o valor de distância Euclidiana para determinado usuário.
	 * @param user usário ao qual será atrbuido o seu valor de distância Euclidana.
	 */
	private void createDistanceValue(User user) {
		
		double distanceValue = 0;
		Histograma userHistogram = new Histograma();
		Histograma averangeProfileHistogram = new Histograma();
		
		for(ProfileTree nodeUser : keep.getUsers()) {
			if(nodeUser.raiz().getData().getUserId().equals(user.getUserId())) {
				userHistogram = nodeUser.raiz().getHistogram();
			}
		}
	
		// 	NÃO ESTÁ ENTRANDO NO LAÇO
		for(NodeUser nodeAverangeProfile : keep.getUsersAverangeProfile().values()) {
			if(nodeAverangeProfile.getData().getRole().equals(user.getRole())) {
				averangeProfileHistogram = nodeAverangeProfile.getHistogram();
			}
		}
		
		double aux = 0;
		for(int i = 0; i < 24; i++) {
			aux += Math.pow(userHistogram.getValue(i) - averangeProfileHistogram.getValue(i), 2);					
		}	
		
		distanceValue = Math.sqrt(aux);	
		user.setDistanceValue(distanceValue);
	}
	
	/**
	 * Método responsável por criar ranking com todos os usário de um determinado papel, em relação ao 
	 * valor de distância dos usuários ao perfil médio do papel.
	 * @param role papel a qual os uuários serão colocados no ranking.
	 * @return ArrayList dos usuários já ordenados.
	 */
	public ArrayList<User> createRanking(String role){
		ArrayList<User> ranking = new ArrayList<User>();
		//String aux;
		for(ProfileTree nodeUser : keep.getUsers()) {   
			if(nodeUser.raiz().getData().getRole().equalsIgnoreCase(role)) {
				ranking.add(nodeUser.raiz().getData());
			}
		}
		
		Collections.sort(ranking);
		
		return ranking;
	}
	
}
