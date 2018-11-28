package br.edu.imd.controller;

import java.util.ArrayList;

import br.edu.imd.model.Histograma;
import br.edu.imd.model.NodeUser;
import br.edu.imd.model.User;
import java.util.Map;

/**
 * Classe controller será responsável por manter toda a organização e divisão de tarefas do sistema.
 * @author Matheus / Felipe
 */
public class Controller {
    
	BildPerfil bild;
	KeepTrees keep;
	AnomalyAnalysis anomaly;
	
	/**
	 * Construtor da classe Controller, inicializando os objetos.
	 */
	Controller(){
		bild = new BildPerfil();
		keep= new KeepTrees();
		anomaly = new AnomalyAnalysis(keep);
	}
	
	/**
	 * Método para criação dos usuários através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createUsers(String wayFile) {
		keep.addUser(bild.buildUser(wayFile));
	}
	
	/**
	 * Método para criação das atvidades de http através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createHttp(String wayFile) {
		keep.addActivity(bild.buildHttp(wayFile));
	}
	
	/**
	 * Método para criação das atvidades de Logon através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createLogon(String wayFile) {
		keep.addActivity(bild.buildLogon(wayFile));
	}
	
	/**
	 * Método para criação das atvidades de Devices através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createDevices(String wayFile) {
		keep.addActivity(bild.buildDevices(wayFile));
	}
	
	/**
	 * Método para criação dos valores de distância entre o histograma dos usários com 
	 * os dos perfis médios de cada papel
	 */
	public void createDistanceValue() {
		anomaly.enterDistanceValue();
	}
	
	/**
	 * Método para verificação se determinado usuário é uma anomalia
	 * @param user usuário a ser verificado
	 * @return boolean com resposta do método analyzerUser da classe anomaly
	 */
	public boolean SearchAnomaly(User user) {
		return anomaly.analyzeUser(user);
	}
	
	/**
	 * Método para criação de ranking dos usuários de determinado papel em relação 
	 * ao valor de distância Euclidiana
	 * @param role papel dos usários a ser colocado no ranking
	 * @return ArrayList de usuário em ordem crescente, ou seja, os primeiros com
	 * os valores mais próximo de zero.
	 */
	public void ShowRanking(String role){
		ArrayList<User> ranking = anomaly.createRanking(role);
		
		for(int i = 0; i < ranking.size(); i++) {
			System.out.println(i+1 + " - " + ranking.get(i).getEmployerName() + " - Value: " + 
			ranking.get(i).getDistanceValue());
		}
	}
	
	/**
	 * Método que mostra a quantidade de usuários cadastrados
	 * @return int com a quantidade de usuários
	 */
	public int qtdUsers() {
		return keep.getUsers().size();
	}
	
	/**
	 * Método que imprime árvore de um usáriuo específico
	 * @param name nome do user a qual será impresso a árvore
	 */
	public void viewUser(String name) {
		for(ProfileTree users : keep.getUsers()) {
			if(users.raiz().getData().getEmployerName().equals(name)) {
				users.preintTree(users.raiz(), " ");
			}
		}
	}
	
	public void viewAverangeProfile(String role) {
                String k ;
                NodeUser v;

		// NÃO ESTÁ ENTRANDO NO LAÇO
		//keep.getUsersAverangeProfile().forEach((k,v) -> {
                 for(Map.Entry<String,NodeUser> entry : keep.getUsersAverangeProfile().entrySet() ){
                      k = entry.getKey();
                      v = entry.getValue();
                     if(k.equals(role)) {
				Histograma histogram = v.getHistogram();
				for(int i = 0; i < 24; i++) {
					System.out.println(histogram.getValue(i) + " | ");
				}
			}
		};
		
		/**
		for(Map.Entry<String,NodeUser> user : keep.getUsersAverangeProfile().entrySet()) {
			System.out.println("Entrou no primeiro laço");
			if(user.getKey().equals(role)) {
				System.out.println("Entrou no if");
				Histograma histogram = user.getValue().getHistogram();
				for(int i = 0; i < 24; i++) {
					System.out.println("Entrou no segundo laço");
					System.out.println(histogram.getValue(i) + " | ");
				}
			}
		}
		*/
	}
        	
}
