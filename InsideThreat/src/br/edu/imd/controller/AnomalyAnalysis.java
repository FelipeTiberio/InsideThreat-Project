package br.edu.imd.controller;

import java.util.ArrayList;
import java.util.Collections;

import br.edu.imd.model.Histograma;
import br.edu.imd.model.NodeUser;
import br.edu.imd.model.User;

public class AnomalyAnalysis {
	KeepTrees keep;
	
	AnomalyAnalysis(){}
	
	AnomalyAnalysis(KeepTrees keep){
		this.keep = keep;
	}
	
	public boolean analyzeUser(User user) {
		
		if(this.searchUser(user) && this.searchAverangeProfile(user)) {	
			
			int contAux = 0;
			double valueAux = 0;
			String roleAux = user.getRole();
			
			for(NodeUser nodeUser : keep.getUsers()) {
				if(nodeUser.getData().getRole().equals(roleAux)) {
					contAux++;
					valueAux += nodeUser.getData().getDistance_value();
				}
			}
			
			valueAux = valueAux/contAux;
			
			if(user.getDistance_value() <= valueAux && user.getDistance_value() > 0) 
				return false;
			
		} else {
			System.out.println("Usu�rio n�o existe ou n�o existe histograma de perfil m�dio do seu"
					+ "papel definido.");
		}
		
		return true;		
	}
	
	public void enterDistanceValue() {
		for(ProfileTree nodeUser : keep.getUsers()) {
			createDistanceValue(nodeUser.raiz().getData());
		}
	}

	private void createDistanceValue(User user) {
		
		double distanceValue = 0;
		Histograma userHistogram = new Histograma();
		Histograma averangeProfileHistogram = new Histograma();
		
		for(ProfileTree nodeUser : keep.getUsers()) {
			if(nodeUser.raiz().getData().getUser_id().equals(user.getUser_id())) {
				userHistogram = nodeUser.raiz().getHistogram();
			}
		}
		
		for(NodeUser nodeAverangeProfile : keep.getUsersAverangeProfile()) {
			if(nodeAverangeProfile.getData().getRole().equals(user.getRole())) {
				averangeProfileHistogram = nodeAverangeProfile.getHistogram();
			}
		}
		
		double aux = 0;
		for(int i = 0; i < 24; i++) {
			aux += Math.pow(userHistogram.getValue(i) - averangeProfileHistogram.getValue(i), 2);					
		}	
		
		distanceValue = Math.sqrt(aux);	
		user.setDistance_value(distanceValue);
	}
	
	public ArrayList<User> createRanking(){
		ArrayList<User> ranking = new ArrayList<User>();
		
		for(ProfileTree nodeUser : keep.getUsers()) {
			ranking.add(nodeUser.raiz().getData());
		}
		
		Collections.sort(ranking);
		
		return ranking;
	}
	
	public boolean searchUser(User user) {
		return false;	
	}
	
	public boolean searchAverangeProfile(User user) {
		return false;	
	}
}
