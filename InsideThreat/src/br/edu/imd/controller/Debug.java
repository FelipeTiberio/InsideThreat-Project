package br.edu.imd.controller;

import java.util.ArrayList;

import br.edu.imd.model.*;



public class Debug {

	public static void main(String[] args) {
	/*	
	// Debug manuel para os métodos da classe keepTree 
	KeepTrees systema = new KeepTrees();
	ArrayList<User> array = new ArrayList();
	ArrayList<Http> http = new ArrayList();
	
	array.add(new User ("Burton M Stephenson","BMS0001","dtaa.com","Burton.M.Stephenson@dtaa.com","Security"));
	http.add(new Http("{M8H9-W9NL75TH-1322KOLO}","01/04/2010 07:08:47","DTAA/BMS0001","PC-1514","http://cnet.com"));
	http.add(new Http("{M8H9-W9NL75TH-1322KO}","01/04/2010 07:08:47","DTAA/BMS0001","PC-1514","http://TTT.com"));
	systema.addUser(array);
	systema.addHttp(http);
	
	System.out.println("Teste da classe keepTree");
	//systema.nome();
        ProfileTree tree =  systema.getUsers().get(0);
        tree.preintTree(tree.raiz()," ");*/
        
        
        System.out.println("Teste para a classe Controller");
        Controller controle = new Controller();
        controle.createUsers("../InsideThreat/Data/LDAP.csv"); // Passado o caminho dos arquivos de user 
        //controle.createUsers("..\InsideThreat\Data" ); //Acho que esse é o semelhante para o windows
        
        
       KeepTrees systema = controle.getKeep();
       System.out.println("Quantidade de árvore de usuários cadastrados: " + systema.getUsers().size());
      
	
	}
	

}
