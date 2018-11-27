package br.edu.imd.controller;

import java.util.ArrayList;
import br.edu.imd.model.User;

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
		keep.addHttp(bild.buildHttp(wayFile));
	}
	
	/**
	 * Método para criação das atvidades de Logon através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createLogon(String wayFile) {
		keep.addLogon(bild.buildLogon(wayFile));
	}
	
	/**
	 * Método para criação das atvidades de Devices através do arquivo
	 * @param wayFile caminho do arquivo com os dados dos usuários
	 */
	public void createDevices(String wayFile) {
		keep.addDevices(bild.buildDevices(wayFile));
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
	public ArrayList<User> ShowRanking(String role){
		return anomaly.createRanking(role);
	}
        
        ////**** Métodos abaixo provavelmente só iram servir como debug

    public KeepTrees getKeep() {
        return keep;
    }
        
        
	
}
