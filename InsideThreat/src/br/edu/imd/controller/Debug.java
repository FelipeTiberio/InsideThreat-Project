package br.edu.imd.controller;

import java.util.Scanner;

public class Debug {

	public static void main(String[] args) {

        Controller controle = new Controller();
        Scanner scan = new Scanner(System.in);
        
        int aux = scan.nextInt();
        
        switch(aux) {
        	case 1:
        		break;
        	case 2:
        		break;
        	case 3: 
        		break;
        	case 4:
        		break;
        	case 5:
        		break;
        }
        /**
         * Criação de todos os usários presente no arquivo LDAP.
         */
        controle.createUsers("../InsideThreat/Data/LDAP.csv"); 
        
        /**
         * Bloco de criação dos dados de atividades em todo o período.
         * OBS.: devido ao elevado tamanho do arquivo de http, temos problema na memória,
         * por isso, recomendamos testar somente com os outros dois.
         */
        //controle.createLogon("../InsideThreat/Data/logon.csv");
        //controle.createDevices("../InsideThreat/Data/device.csv");
        //controle.createHttp("../InsideThreat/Data/http.csv"); 
        
        /**
         * Bloco de criação dos dados em um período específico.
         * Informando após o caminho do arquivo, a data inicial e final, respectivamente.
         * O formato da data deve ser: mm/dd/aaaa.
         */
        controle.createLogon("../InsideThreat/Data/logon.csv","01/04/2010","03/04/2010");
        //controle.createDevices("../InsideThreat/Data/device.csv","01/04/2010","03/04/2010");
        //controle.createHttp("../InsideThreat/Data/http.csv","01/04/2010","03/04/2010"); 
         
        /**
         * Quantidade de usuários cadastrados no sistema.
         */
        System.out.println("\nQuantidade de árvore de usuários cadastrados: " + controle.qtdUsers());
        
        /**
         * Bloco para análise do comportamento dos usuários:
         * Primeiramenete, criamos o valor da distância Euclidana entre os histogramas dos usuários
         * com os histogramas do perfil médio.
         * Após isso, mostramos o ranking com esse valor dos usuários do papel IT Admin.
         * Em seguida, temos a verficação de anomalia em dois usuários desse papel.
         * Por fim, imprimimos todos os histogramas dos perfis médios, ou seja, de todos os papéis
         * presente no sistema pelos os usários cadastrados.*/
         
        //controle.createDistanceValue();
        //controle.showRanking("IT Admin");
        //controle.searchAnomaly("Castor L Nelson");
        //controle.searchAnomaly("Isaiah R Chen");
        //controle.compareUsers("Castor L Nelson", "Isaiah R Chen");
        //controle.viewAllAverangeProfile();
  
        /***
         * Teste para a escrita das árvores em um arquivo
         */
        //controle.saveForest();
         controle.saveProfile("Castor L Nelson");
        
        
    }
}
