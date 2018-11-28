package br.edu.imd.controller;

public class Debug {

	public static void main(String[] args) {
		
		/**
		// Debug manual para os métodos da classe KeepTrees
		KeepTrees systema = new KeepTrees();
		ArrayList<User> array = new ArrayList<User>();
		ArrayList<Activity> http = new ArrayList<Activity>();
	
		array.add(new User ("Burton M Stephenson","BMS0001","dtaa.com","Burton.M.Stephenson@dtaa.com","Security"));
		http.add(new Http("{M8H9-W9NL75TH-1322KOLO}","01/04/2010 07:08:47","DTAA/BMS0001","PC-1514","http://cnet.com"));
		http.add(new Http("{M8H9-W9NL75TH-1322KO}","01/04/2010 07:08:47","DTAA/BMS0001","PC-1514","http://TTT.com"));
		systema.addUser(array);
		systema.addActivity(http);
		ProfileTree tree = systema.getUsers().get(0);
	
		System.out.println("Teste da classe KeepTrees");
		System.out.println("Usuários:");
			systema.nome();
		System.out.println("-----------------------------");
		System.out.println("Árovres:");
    		tree.preintTree(tree.raiz()," ");
        */
		
        System.out.println("Teste para a classe Controller");
        Controller controle = new Controller();
        
        controle.createUsers("../InsideThreat/Data/LDAP.csv"); // Passado o caminho dos arquivos de user 
        controle.createLogon("../InsideThreat/Data/logon.csv");
        controle.createDevices("../InsideThreat/Data/device.csv");
        //controle.createHttp("../InsideThreat/Data/http.csv"); 
         
        System.out.println("Quantidade de árvore de usuários cadastrados: " + controle.qtdUsers());
       	
        /**
        System.out.println("**** Imprimindo a árvore de um user cadastrado ***");
        controle.viewUser("Burton M Stephenson");
        */
        
        controle.createDistanceValue();
        controle.ShowRanking("Security");
        // NÃO ESTÁ ACESSANDO, POIS TODOS OS LAÇOS ENVOLVENDO O MAP DE PERFIS MÉDIOS NÃ ESTÃO ENTRANDO!
        controle.viewAverangeProfile("Security");

        
    }
}
