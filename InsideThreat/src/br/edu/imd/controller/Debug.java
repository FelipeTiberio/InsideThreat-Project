package br.edu.imd.controller;

public class Debug {

	public static void main(String[] args) {

        System.out.println("Teste para a classe Controller");
        Controller controle = new Controller();
        
        controle.createUsers("../InsideThreat/Data/LDAP.csv"); // Passado o caminho dos arquivos de user 
        controle.createLogon("../InsideThreat/Data/logon.csv");
        controle.createDevices("../InsideThreat/Data/device.csv");
        //controle.createHttp("../InsideThreat/Data/http.csv"); 
         
        System.out.println("\nQuantidade de árvore de usuários cadastrados: " + controle.qtdUsers());
       	
        //System.out.println("**** Imprimindo a árvore de um user cadastrado ***");
        //controle.viewUser("Burton M Stephenson");
        
        controle.createDistanceValue();
        controle.ShowRanking("IT Admin");
        controle.SearchAnomaly("Castor L Nelson");
        controle.SearchAnomaly("Isaiah R Chen");
        controle.viewAllAverangeProfile();
  
    }
}
