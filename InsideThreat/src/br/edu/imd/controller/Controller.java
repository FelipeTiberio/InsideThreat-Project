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
	 * Método para criação das atvidades de http através do arquivo em um período específico.
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createHttp(String wayFile, String startDate, String finalDate) {
		keep.addActivity(bild.buildHttp(wayFile, startDate, finalDate));
	}
	
	/**
	 * Método para criação das atvidades de Logon através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createLogon(String wayFile) {
		keep.addActivity(bild.buildLogon(wayFile));
	}
	
	/**
	 * Método para criação das atvidades de Logon através do arquivo em um período específico.
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createLogon(String wayFile, String startDate, String finalDate) {
		keep.addActivity(bild.buildLogon(wayFile, startDate, finalDate));
	}
	
	/**
	 * Método para criação das atvidades de Devices através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createDevices(String wayFile) {
		keep.addActivity(bild.buildDevices(wayFile));
	}
	
	/**
	 * Método para criação das atvidades de Devices através do arquivoem um período específico.
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createDevices(String wayFile, String startDate, String finalDate) {
		keep.addActivity(bild.buildDevices(wayFile, startDate, finalDate));
	}
	
	/**
	 * Método para criação dos valores de distância entre o histograma dos usários com 
	 * os dos perfis médios de cada papel. Antes realizo a atulização dos valores dos 
	 * histogramas dos perfis médios.
	 */
	public void createDistanceValue() {
		keep.attHistogram();
		anomaly.enterDistanceValue();
	}
	
	/**
	 * Método para verificação se determinado usuário é uma anomalia
	 * @param user usuário a ser verificado
	 */
	public void searchAnomaly(String name) {
		if(anomaly.analyzeUser(name)) {
			 System.out.println("O usuário " + name + " é uma anomalia!");
		 } else {
			 System.out.println("O usuário " + name + " não é uma anomalia!");
		 }
	}
		
	/**
	 * Método que imprime árvore de um usáriuo específico
	 * @param name nome do user a qual será impresso a árvore
	 */
	public void viewUser(String name) {
		if(keep.existUser(name)) {
			for(ProfileTree users : keep.getUsers()) {
				if(users.raiz().getData().getEmployerName().equals(name)) {
					users.preintTree(users.raiz(), " ");
				}
			}
		} else {
			System.out.println("Não existe user com esse id");
		}
	}
	
	/**
	 * Método para compara dois usuários, assim mostrando seus histogramas.
	 * @param nameOne O nome do primeiro usuário a ser comparado
	 * @param nameTwo O nome do segundo usuário a ser comparado
	 */
	public void compareUsers(String nameOne, String nameTwo) {
		if(keep.existUser(nameOne) && keep.existUser(nameTwo)) {
			for(ProfileTree users : keep.getUsers()) {
				if(users.raiz().getData().getEmployerName().equals(nameOne)) {
					Histograma histogram = users.raiz().getHistogram();
					System.out.println("\n----- Histograma do usuário " + users.raiz().getData().getEmployerName() + " -----");
					for(int i = 0; i < 24; i++) {
						System.out.print(histogram.getValue(i) + " | ");
					}
					System.out.print("\n");
				} else if(users.raiz().getData().getEmployerName().equals(nameTwo)){
					Histograma histogram = users.raiz().getHistogram();
					System.out.println("\n----- Histograma do usuário " + users.raiz().getData().getEmployerName() + " -----");
					for(int i = 0; i < 24; i++) {
						System.out.print(histogram.getValue(i) + " | ");
					}
					System.out.print("\n");
				}
			}
		} else {
			System.out.println("Algum dos usuários não existem.");
		}
	}
	
	/**
	 * Método para visualização de histograma de um perfil médio.
	 * Verifico se o histograma do perfil médio está atualizado primeiramente,
	 * caso não, realizado a atualização.
	 * @param role papel do perfil médio desejado
	 */
	public void viewAverangeProfile(String role) {
		if(keep.existAverangeProfile(role)) {
			if(keep.getUsersAverangeProfile().get(role).getHistogram().isAtt()) {
				Histograma histogram = keep.getUsersAverangeProfile().get(role).getHistogram();
				System.out.println("----- Histograma do perfil médio do papel " + role + " -----");
				for(int i = 0; i < 24; i++) {
					System.out.print(histogram.getValue(i) + " | ");
				}
			} else {
				keep.getUsersAverangeProfile().get(role).attValuesAvernageProfile();
				viewAverangeProfile(role);
			}
		} else {
			System.out.println("Não existe perfil médio com esse papel.");
		}	
	}
	
	/**
	 * Método para visualização de todos os histograma de perfis médios.
	 */
	public void viewAllAverangeProfile() {
		System.out.print("\n");
		for(Map.Entry<String, NodeUser> users : keep.getUsersAverangeProfile().entrySet()) {
			Histograma histogram = users.getValue().getHistogram();
			System.out.println("----- Histograma do perfil médio do papel " + users.getKey() + " -----");
			for(int i = 0; i < 24; i++) {
				System.out.print(histogram.getValue(i) + " | ");
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * Método para criação de ranking dos usuários de determinado papel em relação 
	 * ao valor de distância Euclidiana
	 * @param role papel dos usários a ser colocado no ranking
	 * @return ArrayList de usuário em ordem crescente, ou seja, os primeiros com
	 * os valores mais próximo de zero.
	 */
	public void showRanking(String role){
		ArrayList<User> ranking = anomaly.createRanking(role);
		System.out.println("\n----- Ranking de usuários do papel " + role + " -----");
		for(int i = 0; i < ranking.size(); i++) {
			System.out.println(i+1 + " - " + ranking.get(i).getEmployerName() + " - Value: " + 
			ranking.get(i).getDistanceValue());
		}
		System.out.print("\n");
	}
	
	/**
	 * Método que mostra a quantidade de usuários cadastrados
	 * @return int com a quantidade de usuários
	 */
	public int qtdUsers() {
		return keep.getUsers().size();
	}
        	
}
